package com.xl.backen.dao;

import com.xl.backen.entity.ParentMenus;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;


/**
 * 父级菜单表(TbParentMenus)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-09 22:17:29
 */
@Repository
public interface ParentMenusMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ParentMenus queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ParentMenus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param parentMenus 实例对象
     * @return 对象列表
     */
    Page<ParentMenus> queryAll(ParentMenus parentMenus);

    /**
     * 新增数据
     *
     * @param parentMenus 实例对象
     * @return 影响行数
     */
    int insert(ParentMenus parentMenus);

    /**
     * 修改数据
     *
     * @param parentMenus 实例对象
     * @return 影响行数
     */
    int update(ParentMenus parentMenus);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}