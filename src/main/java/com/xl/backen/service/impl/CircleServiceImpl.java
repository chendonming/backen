package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CircleMapper;
import com.xl.backen.dao.CirclePeopleMapper;
import com.xl.backen.entity.Circle;
import com.xl.backen.entity.CirclePeople;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.CircleService;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private CircleMapper cm;

    @Autowired
    private CirclePeopleMapper cpm;


    @Override
    public int del(Circle circle) {
        if (StringUtil.isEmpty(circle.getUuid())) {
            throw new BusinessException(500, "uuid不能为空");
        }
        circle.setFlag(CommonConst.DEL_STATUS);
        return cm.updateByPrimaryKeySelective(circle);
    }

    @Override
    public Circle queryOne(Circle circle) {
        String uuid = "";
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if(obj instanceof Peoples) {
            uuid = ((Peoples) obj).getUuid();
        }
        if(obj instanceof Users) {
            uuid = ((Users) obj).getUuid();
        }
        Circle cc = cm.selectByPrimaryKey(circle.getUuid());
        int count = cm.isJoinCircle(circle.getUuid(), uuid) == null ? 0 : cm.isJoinCircle(circle.getUuid(), uuid);

        if (count == 0) {
            //未加入
            cc.setIsJoin(2);
        } else {
            // 已加入
            cc.setIsJoin(1);
        }
        return cc;
    }

    @Override
    public int add(Circle circle) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        circle.setUuid(uuid);
        circle.setStatus(CommonConst.CIRCLE_NORMAL_STATUS);
        circle.setFlag(CommonConst.NORMAL_STATUS);
        circle.setCreateTime(new Date());
        circle.setUpdateTime(new Date());
        circle.setWeight(0);
        return cm.insertSelective(circle);
    }

    @Override
    public int update(Circle circle) {
        if (StringUtil.isEmpty(circle.getUuid())) {
            throw new BusinessException(500, "uuid不能为空");
        }
        circle.setUpdateTime(new Date());
        return cm.updateByPrimaryKeySelective(circle);
    }

    @Override
    public Page<Circle> query(Map<String, Object> map) {
        if (map.get("pageSize") != null && map.get("pageNum") != null) {
            PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        }
        Page<Circle> circlePage = cm.queryAll(map);
        return circlePage;
    }

    @Override
    @Transactional
    public int joinCircle(CirclePeople cp) {
        Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
        int count = cm.isJoinCircle(cp.getCircleId(), peoples.getUuid()) == null ? 0 : cm.isJoinCircle(cp.getCircleId(), peoples.getUuid());
        if (count == 0) {
            // 未加入此圈子
            cp.setPeopleId(peoples.getUuid());
            cp.setFlag(CommonConst.NORMAL_STATUS);
            cp.setCreateTime(new Date());
            cp.setUpdateTime(new Date());
            cm.joinCircle(cp);
        } else {
            // 已加入圈子则取消
            cp.setPeopleId(peoples.getUuid());
            List<CirclePeople> people = cpm.queryAll(cp).getResult();
            if (people.size() == 1) {
                CirclePeople p = people.get(0);
                p.setFlag(CommonConst.DEL_STATUS);
                cpm.update(people.get(0));
            } else {
                throw new BusinessException(500, "加入圈子异常联系管理员");
            }
        }
        return 1;
    }
}
