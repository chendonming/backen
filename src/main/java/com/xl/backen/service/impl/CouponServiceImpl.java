package com.xl.backen.service.impl;

import com.xl.backen.entity.Coupon;
import com.xl.backen.dao.CouponMapper;
import com.xl.backen.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.UUID;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.util.StringUtil;

/**
 * 优惠券(TbCoupon)表服务实现类
 *
 * @author chendm
 * @since 2018-10-25 20:50:44
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponMapper couponDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Coupon queryById(String uuid) {
        return this.couponDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Coupon> queryAllByLimit(int offset, int limit) {
        return this.couponDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    @Override
    public Coupon insert(Coupon coupon) {
        coupon.setUuid(UUID.randomUUID().toString().replace("-", ""));
        coupon.setUpdateTime(new Date());
        coupon.setCreateTime(new Date());
        coupon.setFlag(CommonConst.NORMAL_STATUS);
        this.couponDao.insert(coupon);
        return coupon;
    }

    /**
     * 修改数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    @Override
    public Coupon update(Coupon coupon) {
        if(StringUtil.isEmpty(coupon.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        coupon.setUpdateTime(new Date());
        this.couponDao.update(coupon);
        return this.queryById(coupon.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.couponDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param coupon 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Coupon> queryAll(Coupon coupon) {
        if(coupon.getPageSize() != null && coupon.getPageNum() != null) {
            PageHelper.startPage(coupon.getPageNum(), coupon.getPageSize());
        }
        Page<Coupon> pages =  this.couponDao.queryAll(coupon);
        return pages;
    }
}