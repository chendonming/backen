package com.xl.backen.dao;

import com.xl.backen.entity.Hotline;
import org.springframework.stereotype.Repository;

@Repository
public interface HotlineMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Hotline record);

    int insertSelective(Hotline record);

    Hotline selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Hotline record);

    int updateByPrimaryKey(Hotline record);

    Hotline queryOne(String uuid);
}