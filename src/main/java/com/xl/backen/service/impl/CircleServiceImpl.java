package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CircleMapper;
import com.xl.backen.entity.Circle;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.CircleService;
import com.xl.backen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private CircleMapper cm;


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
        return cm.selectByPrimaryKey(circle.getUuid());
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
}
