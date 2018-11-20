package com.xl.backen.controller;

import com.xl.backen.entity.Merchant;
import com.xl.backen.service.MerchantService;
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
 * (TbMerchant)表控制层
 *
 * @author chendm
 * @since 2018-11-14 21:24:46
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {
    private static Logger log = LoggerFactory.getLogger(MerchantController.class);

    /**
     * 服务对象
     */
    @Resource
    private MerchantService merchantService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Merchant> queryOne(@RequestBody Merchant merchant) {
        log.info("查询单个,uuid={}", merchant.getUuid());

        Merchant one = merchantService.queryById(merchant.getUuid());
        return new Result<Merchant>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Merchant> add(@RequestBody Merchant merchant) {
        log.info("新增,merchant={}", merchant);

        Merchant one = merchantService.insert(merchant);
        return new Result<Merchant>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Merchant> update(@RequestBody Merchant merchant) {
        log.info("修改,merchant={}", merchant);

        Merchant one = merchantService.update(merchant);
        return new Result<Merchant>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Merchant> queryAll(@RequestBody Merchant merchant) {
        log.info("分页查询,merchant={}", merchant);

        Page<Merchant> one = merchantService.queryAll(merchant);
        PageInfo<Merchant> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Merchant>(BusinessStatus.SUCCESS,pageinfo);
    }

}