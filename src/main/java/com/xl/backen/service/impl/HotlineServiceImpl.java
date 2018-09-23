package com.xl.backen.service.impl;

import com.xl.backen.dao.HotlineMapper;
import com.xl.backen.entity.Hotline;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.service.HotlineService;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class HotlineServiceImpl implements HotlineService {
    @Autowired
    private HotlineMapper ho;

    /*
    * 新增
    * */
    @Override
    public int add(Hotline hotline) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        hotline.setUuid(uuid);
        hotline.setUpdateTime(new Date());
        Users peoples = (Users) SecurityUtils.getSubject().getPrincipal();
        hotline.setCommunityId(peoples.getCommunityId());
        return ho.insertSelective(hotline);
    }

    /*
     * 修改
     * */
    @Override
    public int update(Hotline hotline) {
        if (StringUtil.isEmpty(hotline.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        if(StringUtil.isEmpty(hotline.getCommunityId())) {
            throw new BusinessException(500, "组织id不能为空");
        }
        hotline.setUpdateTime(new Date());
        return ho.updateByPrimaryKeySelective(hotline);
    }

    /*
     * 单个查询
     * */
    @Override
    public Hotline queryOne(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        return ho.selectByPrimaryKey(uuid);
    }
}
