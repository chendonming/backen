package com.xl.backen.dao;

import com.xl.backen.entity.Notices;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;


/**
 * 公告表(TbNotices)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
@Repository
public interface NoticesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Notices queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notices> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param notices 实例对象
     * @return 对象列表
     */
    Page<Notices> queryAll(Notices notices);

    /**
     * 新增数据
     *
     * @param notices 实例对象
     * @return 影响行数
     */
    int insert(Notices notices);

    /**
     * 修改数据
     *
     * @param notices 实例对象
     * @return 影响行数
     */
    int update(Notices notices);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}