package com.xl.backen.service;

import com.xl.backen.entity.ComplaintComment;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * (TbComplaintComment)表服务接口
 *
 * @author chendm
 * @since 2018-09-23 20:31:00
 */
public interface ComplaintCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    ComplaintComment queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ComplaintComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param complaintComment 实例对象
     * @return 实例对象
     */
    ComplaintComment insert(ComplaintComment complaintComment);

    /**
     * 修改数据
     *
     * @param complaintComment 实例对象
     * @return 实例对象
     */
    ComplaintComment update(ComplaintComment complaintComment);

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
     * @param complaintComment 实例对象
     * @return 对象列表
     */
    Page<ComplaintComment> queryAll(ComplaintComment complaintComment);
}