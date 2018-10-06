package com.xl.backen.dao;

import com.xl.backen.entity.CirclePostComment;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;


/**
 * (TbCirclePostComment)表数据库访问层
 *
 * @author chendm
 * @since 2018-10-04 16:07:42
 */
public interface CirclePostCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    CirclePostComment queryById(String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CirclePostComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param circlePostComment 实例对象
     * @return 对象列表
     */
    Page<CirclePostComment> queryAll(CirclePostComment circlePostComment);

    /**
     * 新增数据
     *
     * @param circlePostComment 实例对象
     * @return 影响行数
     */
    int insert(CirclePostComment circlePostComment);

    /**
     * 修改数据
     *
     * @param circlePostComment 实例对象
     * @return 影响行数
     */
    int update(CirclePostComment circlePostComment);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}