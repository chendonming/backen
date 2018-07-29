package com.xl.backen.dao;

import com.xl.backen.entity.Menus;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);
}