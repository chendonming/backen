package com.xl.backen.service;

import com.xl.backen.entity.Articles;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 文章表(TbArticles)表服务接口
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
public interface ArticlesService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Articles queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Articles> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param articles 实例对象
     * @return 实例对象
     */
    Articles insert(Articles articles);

    /**
     * 修改数据
     *
     * @param articles 实例对象
     * @return 实例对象
     */
    Articles update(Articles articles);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    boolean deleteById(String uuid);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param articles 实例对象
     * @return 对象列表
     */
    Page<Articles> queryAll(Articles articles);
}