package com.xl.backen.controller;

import com.xl.backen.entity.Pictures;
import com.xl.backen.service.PicturesService;
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
 * 轮播图管理(TbPictures)表控制层
 *
 * @author chendm
 * @since 2018-11-03 21:05:11
 */
@RestController
@RequestMapping("/pictures")
public class PicturesController {
    private static Logger log = LoggerFactory.getLogger(PicturesController.class);

    /**
     * 服务对象
     */
    @Resource
    private PicturesService picturesService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Pictures> queryOne(@RequestBody Pictures pictures) {
        log.info("查询单个,uuid={}", pictures.getUuid());

        Pictures one = picturesService.queryById(pictures.getUuid());
        return new Result<Pictures>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Pictures> add(@RequestBody Pictures pictures) {
        log.info("新增,pictures={}", pictures);

        Pictures one = picturesService.insert(pictures);
        return new Result<Pictures>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Pictures> update(@RequestBody Pictures pictures) {
        log.info("修改,pictures={}", pictures);

        Pictures one = picturesService.update(pictures);
        return new Result<Pictures>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Pictures> queryAll(@RequestBody Pictures pictures) {
        log.info("分页查询,pictures={}", pictures);

        Page<Pictures> one = picturesService.queryAll(pictures);
        PageInfo<Pictures> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Pictures>(BusinessStatus.SUCCESS,pageinfo);
    }

}