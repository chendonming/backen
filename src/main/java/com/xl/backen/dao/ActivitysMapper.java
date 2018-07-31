package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;

import org.springframework.stereotype.Repository;

@Repository
public interface ActivitysMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Activitys record);

    int insertSelective(Activitys record);

    Activitys selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Activitys record);

    int updateByPrimaryKey(Activitys record);

    Page<Activitys> query(Activitys activitys);
}