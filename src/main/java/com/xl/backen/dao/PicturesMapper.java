package com.xl.backen.dao;

import com.xl.backen.entity.Pictures;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;


/**
 * 轮播图管理(TbPictures)表数据库访问层
 *
 * @author chendm
 * @since 2018-11-03 21:05:11
 */
@Repository
public interface PicturesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Pictures queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pictures> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pictures 实例对象
     * @return 对象列表
     */
    Page<Pictures> queryAll(Pictures pictures);

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 影响行数
     */
    int insert(Pictures pictures);

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 影响行数
     */
    int update(Pictures pictures);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}