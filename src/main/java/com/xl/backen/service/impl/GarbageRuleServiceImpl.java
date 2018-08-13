package com.xl.backen.service.impl;

import com.xl.backen.dao.GarbageRuleMapper;
import com.xl.backen.entity.GarbageRule;
import com.xl.backen.entity.Users;
import com.xl.backen.service.GarbageRuleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GarbageRuleServiceImpl implements GarbageRuleService {
    @Autowired
    private GarbageRuleMapper grm;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return grm.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(GarbageRule record) {
        return grm.insert(record);
    }

    @Override
    public int insertSelective(GarbageRule record) {
        record.setUuid(UUID.randomUUID().toString().replace("-",""));

        Users users = (Users)SecurityUtils.getSubject().getPrincipal();

        record.setSysType(users.getSysType());

        return grm.insertSelective(record);
    }

    @Override
    public GarbageRule selectByPrimaryKey() {
        Users users = (Users)SecurityUtils.getSubject().getPrincipal();
        return grm.queryLimit(users.getSysType());
    }

    @Override
    public int updateByPrimaryKeySelective(GarbageRule record) {
        return grm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GarbageRule record) {
        return grm.updateByPrimaryKey(record);
    }
}
