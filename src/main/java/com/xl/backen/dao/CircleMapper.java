package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CircleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Circle record);

    int insertSelective(Circle record);

    Circle selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Circle record);

    int updateByPrimaryKey(Circle record);

    Page<Circle> queryAll(Map<String, Object> map);
}