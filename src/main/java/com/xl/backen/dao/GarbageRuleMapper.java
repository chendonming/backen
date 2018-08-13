package com.xl.backen.dao;

import com.xl.backen.entity.GarbageRule;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageRuleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(GarbageRule record);

    int insertSelective(GarbageRule record);

    GarbageRule selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(GarbageRule record);

    int updateByPrimaryKey(GarbageRule record);

    /**
     * 查询第一个
     */
    GarbageRule queryLimit(String sysType);
}