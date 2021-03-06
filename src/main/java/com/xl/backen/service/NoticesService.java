package com.xl.backen.service;

import com.xl.backen.entity.Notices;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 公告表(TbNotices)表服务接口
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
public interface NoticesService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Notices queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notices> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param notices 实例对象
     * @return 实例对象
     */
    Notices insert(Notices notices);

    /**
     * 修改数据
     *
     * @param notices 实例对象
     * @return 实例对象
     */
    Notices update(Notices notices);

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
     * @param notices 实例对象
     * @return 对象列表
     */
    Page<Notices> queryAll(Notices notices);
}