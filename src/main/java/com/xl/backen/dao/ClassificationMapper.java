package com.xl.backen.dao;

import com.xl.backen.entity.Classification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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