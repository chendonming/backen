package com.xl.backen.dao;

import com.xl.backen.entity.ComplaintComment;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;


/**
 * (TbComplaintComment)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
@Repository
public interface ComplaintCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ComplaintComment queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComplaintComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param complaintComment 实例对象
     * @return 对象列表
     */
    Page<ComplaintComment> queryAll(ComplaintComment complaintComment);

    /**
     * 新增数据
     *
     * @param complaintComment 实例对象
     * @return 影响行数
     */
    int insert(ComplaintComment complaintComment);

    /**
     * 修改数据
     *
     * @param complaintComment 实例对象
     * @return 影响行数
     */
    int update(ComplaintComment complaintComment);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}