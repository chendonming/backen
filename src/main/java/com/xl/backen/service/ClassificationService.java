package com.xl.backen.service;

import com.xl.backen.entity.Classification;
import com.xl.backen.model.ClassificationListModel;

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

    /**
     * 查询单个
     * @param uuid
     * @return
     */
    Classification queryOne(String uuid);

    /**
     * 查询栏目并带出相应文章
     * @param classification
     * @return
     */
    List<ClassificationListModel> queryAndArticle(Classification classification);
}
