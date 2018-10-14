package com.xl.backen.service;

import com.xl.backen.entity.Coupon;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 优惠券(TbCoupon)表服务接口
 *
 * @author chendm
 * @since 2018-10-13 09:04:19
 */
public interface CouponService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    Coupon queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Coupon> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    Coupon insert(Coupon coupon);

    /**
     * 修改数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    Coupon update(Coupon coupon);

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
     * @param coupon 实例对象
     * @return 对象列表
     */
    Page<Coupon> queryAll(Coupon coupon);
}