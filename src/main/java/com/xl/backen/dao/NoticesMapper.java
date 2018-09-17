package com.xl.backen.dao;

import java.util.Map;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Notices;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticesMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Notices record);

    int insertSelective(Notices record);

    Notices selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Notices record);

    int updateByPrimaryKey(Notices record);
    
    Page<Notices> queryAll(Map<String, Object> map);
}