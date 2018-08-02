package com.xl.backen.dao;

import com.xl.backen.entity.Communitys;

public interface CommunitysMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Communitys record);

    int insertSelective(Communitys record);

    Communitys selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Communitys record);

    int updateByPrimaryKey(Communitys record);
}