package com.xl.backen.service.impl;

import com.xl.backen.dao.GarbageRuleMapper;
import com.xl.backen.entity.GarbageRule;
import com.xl.backen.entity.Users;
import com.xl.backen.service.GarbageRuleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@CacheConfig(cacheNames = "garbage")
public class GarbageRuleServiceImpl implements GarbageRuleService {
    @Autowired
    private GarbageRuleMapper grm;

    @Override
    @CacheEvict(allEntries=true)
    public int deleteByPrimaryKey(String uuid) {
        return grm.deleteByPrimaryKey(uuid);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int insert(GarbageRule record) {
        return grm.insert(record);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int insertSelective(GarbageRule record) {
        record.setUuid(UUID.randomUUID().toString().replace("-",""));

        return grm.insertSelective(record);
    }

    @Override
    @Cacheable(keyGenerator = "keyGenerator")
    public GarbageRule findBy(String sysType) {
        System.out.println("service----------------" + sysType);
        return grm.queryLimit(sysType);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int updateByPrimaryKeySelective(GarbageRule record) {
        return grm.updateByPrimaryKeySelective(record);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int updateByPrimaryKey(GarbageRule record) {
        return grm.updateByPrimaryKey(record);
    }
}
