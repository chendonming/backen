package com.xl.backen.controller;

import com.xl.backen.entity.Coupon;
import com.xl.backen.service.CouponService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.handler.BusinessStatus;

/**
 * 优惠券(TbCoupon)表控制层
 *
 * @author chendm
 * @since 2018-10-25 20:50:44
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {
    private static Logger log = LoggerFactory.getLogger(CouponController.class);

    /**
     * 服务对象
     */
    @Resource
    private CouponService couponService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Coupon> queryOne(@RequestBody Coupon coupon) {
        log.info("查询单个,uuid={}", coupon.getUuid());

        Coupon one = couponService.queryById(coupon.getUuid());
        return new Result<Coupon>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Coupon> add(@RequestBody Coupon coupon) {
        log.info("新增,coupon={}", coupon);

        Coupon one = couponService.insert(coupon);
        return new Result<Coupon>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Coupon> update(@RequestBody Coupon coupon) {
        log.info("修改,coupon={}", coupon);

        Coupon one = couponService.update(coupon);
        return new Result<Coupon>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Coupon> queryAll(@RequestBody Coupon coupon) {
        log.info("分页查询,coupon={}", coupon);

        Page<Coupon> one = couponService.queryAll(coupon);
        PageInfo<Coupon> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Coupon>(BusinessStatus.SUCCESS,pageinfo);
    }

}