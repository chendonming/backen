package com.xl.backen.dao;

import com.xl.backen.entity.Articles;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;


/**
 * 文章表(TbArticles)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
public interface ArticlesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Articles queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Articles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articles 实例对象
     * @return 对象列表
     */
    Page<Articles> queryAll(Articles articles);

    /**
     * 新增数据
     *
     * @param articles 实例对象
     * @return 影响行数
     */
    int insert(Articles articles);

    /**
     * 修改数据
     *
     * @param articles 实例对象
     * @return 影响行数
     */
    int update(Articles articles);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}