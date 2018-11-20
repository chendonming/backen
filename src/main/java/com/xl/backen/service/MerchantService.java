package com.xl.backen.service;

import com.xl.backen.entity.Merchant;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * (TbMerchant)表服务接口
 *
 * @author chendm
 * @since 2018-11-14 21:24:46
 */
public interface MerchantService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Merchant queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Merchant> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    Merchant insert(Merchant merchant);

    /**
     * 修改数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    Merchant update(Merchant merchant);

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
     * @param merchant 实例对象
     * @return 对象列表
     */
    Page<Merchant> queryAll(Merchant merchant);
}