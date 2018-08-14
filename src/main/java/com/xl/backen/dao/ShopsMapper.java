package com.xl.backen.dao;

import java.util.Map;

import com.github.pagehelper.Page;
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
    
    Page<Shops> query(Map<String,Object> map);
}