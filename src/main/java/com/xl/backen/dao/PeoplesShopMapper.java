package com.xl.backen.dao;

import com.xl.backen.entity.PeoplesShop;
import org.springframework.stereotype.Repository;

@Repository
public interface PeoplesShopMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PeoplesShop record);

    int insertSelective(PeoplesShop record);

    PeoplesShop selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PeoplesShop record);

    int updateByPrimaryKey(PeoplesShop record);
}