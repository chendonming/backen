package com.xl.backen.service;

import com.xl.backen.entity.GarbageRule;

public interface GarbageRuleService {
    int deleteByPrimaryKey(String uuid);

    int insert(GarbageRule record);

    int insertSelective(GarbageRule record);

    GarbageRule selectByPrimaryKey();

    int updateByPrimaryKeySelective(GarbageRule record);

    int updateByPrimaryKey(GarbageRule record);
}
