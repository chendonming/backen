package com.xl.backen.dao;

import com.xl.backen.entity.Shops;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopsMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Shops record);

    int insertSelective(Shops record);

    Shops selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Shops record);

    int updateByPrimaryKey(Shops record);
}