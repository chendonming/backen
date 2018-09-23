package com.xl.backen.service;

import com.xl.backen.entity.Classification;

import java.util.List;

public interface ClassificationService {
    int add(Classification classification);

    int update(Classification classification);

    /**
     * 查询分类<完整树形></>
     * @return
     */
    Classification queryAll(Classification classification);

    /**
     * 条件查询分类结构
     * @param classification
     * @return
     */
    List<Classification> queryByIf(Classification classification);
}
