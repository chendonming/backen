package com.xl.backen.service;

import com.xl.backen.entity.ParentMenus;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 父级菜单表(TbParentMenus)表服务接口
 *
 * @author chendm
 * @since 2018-10-12 20:09:07
 */
public interface ParentMenusService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ParentMenus queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ParentMenus> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param parentMenus 实例对象
     * @return 实例对象
     */
    ParentMenus insert(ParentMenus parentMenus);

    /**
     * 修改数据
     *
     * @param parentMenus 实例对象
     * @return 实例对象
     */
    ParentMenus update(ParentMenus parentMenus);

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
     * @param parentMenus 实例对象
     * @return 对象列表
     */
    Page<ParentMenus> queryAll(ParentMenus parentMenus);
}