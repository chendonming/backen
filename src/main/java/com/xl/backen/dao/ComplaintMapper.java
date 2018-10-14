package com.xl.backen.dao;

import com.xl.backen.entity.Complaint;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;


/**
 * 建议投诉(TbComplaint)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
public interface ComplaintMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Complaint queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complaint> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param complaint 实例对象
     * @return 对象列表
     */
    Page<Complaint> queryAll(Complaint complaint);

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int insert(Complaint complaint);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int update(Complaint complaint);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}