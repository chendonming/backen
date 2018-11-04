package com.xl.backen.service;

import com.xl.backen.entity.Pictures;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 轮播图管理(TbPictures)表服务接口
 *
 * @author chendm
 * @since 2018-11-03 21:05:11
 */
public interface PicturesService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Pictures queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pictures> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    Pictures insert(Pictures pictures);

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    Pictures update(Pictures pictures);

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
     * @param pictures 实例对象
     * @return 对象列表
     */
    Page<Pictures> queryAll(Pictures pictures);
}