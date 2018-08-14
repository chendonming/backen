package com.xl.backen.dao;

import com.xl.backen.entity.PeoplesIntegralInt;
import org.springframework.stereotype.Repository;

@Repository
public interface PeoplesIntegralIntMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PeoplesIntegralInt record);

    int insertSelective(PeoplesIntegralInt record);

    PeoplesIntegralInt selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PeoplesIntegralInt record);

    int updateByPrimaryKey(PeoplesIntegralInt record);
}