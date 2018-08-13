package com.xl.backen.dao;

import com.xl.backen.entity.PeoplesIntegralOut;

public interface PeoplesIntegralOutMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PeoplesIntegralOut record);

    int insertSelective(PeoplesIntegralOut record);

    PeoplesIntegralOut selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PeoplesIntegralOut record);

    int updateByPrimaryKey(PeoplesIntegralOut record);
}