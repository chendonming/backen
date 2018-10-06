package com.xl.backen.controller;

import com.xl.backen.entity.Notices;
import com.xl.backen.service.NoticesService;
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
 * 公告表(TbNotices)表控制层
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
@RestController
@RequestMapping("/notices")
public class NoticesController {
    private static Logger log = LoggerFactory.getLogger(NoticesController.class);

    /**
     * 服务对象
     */
    @Resource
    private NoticesService noticesService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Notices> queryOne(@RequestBody Notices notices) {
        log.info("查询单个,uuid={}", notices.getUuid());

        Notices one = noticesService.queryById(notices.getUuid());
        return new Result<Notices>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Notices> add(@RequestBody Notices notices) {
        log.info("新增,notices={}", notices);

        Notices one = noticesService.insert(notices);
        return new Result<Notices>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Notices> update(@RequestBody Notices notices) {
        log.info("修改,notices={}", notices);

        Notices one = noticesService.update(notices);
        return new Result<Notices>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Notices> queryAll(@RequestBody Notices notices) {
        log.info("分页查询,notices={}", notices);

        Page<Notices> one = noticesService.queryAll(notices);
        PageInfo<Notices> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Notices>(BusinessStatus.SUCCESS,pageinfo);
    }

}