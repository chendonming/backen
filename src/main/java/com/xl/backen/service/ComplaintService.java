package com.xl.backen.service;

import com.xl.backen.entity.Complaint;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 建议投诉(TbComplaint)表服务接口
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
public interface ComplaintService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Complaint queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complaint> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    Complaint insert(Complaint complaint);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    Complaint update(Complaint complaint);

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
     * @param complaint 实例对象
     * @return 对象列表
     */
    Page<Complaint> queryAll(Complaint complaint);
}