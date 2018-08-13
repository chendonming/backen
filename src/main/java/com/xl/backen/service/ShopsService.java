package com.xl.backen.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Shops;

public interface ShopsService {

    int insertSelective(Shops record);

    Shops selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Shops record);

    //分页查询商品
    Page<Shops> query(Map<String,Integer> map);
}
