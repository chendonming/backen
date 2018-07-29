package com.xl.backen.dao;

import com.xl.backen.entity.Powers;
import org.springframework.stereotype.Repository;

@Repository
public interface PowersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Powers record);

    int insertSelective(Powers record);

    Powers selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Powers record);

    int updateByPrimaryKey(Powers record);
}