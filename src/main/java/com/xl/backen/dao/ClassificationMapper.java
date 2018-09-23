package com.xl.backen.dao;

import com.xl.backen.entity.Classification;

import java.util.List;

public interface ClassificationMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Classification record);

    int insertSelective(Classification record);

    Classification selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);

    /**
     * 查询全部
     * @param classification
     * @return
     */
    List<Classification> queryAll(Classification classification);
}