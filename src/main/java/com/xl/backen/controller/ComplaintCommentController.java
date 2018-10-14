package com.xl.backen.controller;

import com.xl.backen.entity.ComplaintComment;
import com.xl.backen.service.ComplaintCommentService;
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
 * (TbComplaintComment)表控制层
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
@RestController
@RequestMapping("/complaintComment")
public class ComplaintCommentController {
    private static Logger log = LoggerFactory.getLogger(ComplaintCommentController.class);

    /**
     * 服务对象
     */
    @Resource
    private ComplaintCommentService complaintCommentService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ComplaintComment> queryOne(@RequestBody ComplaintComment complaintComment) {
        log.info("查询单个,uuid={}", complaintComment.getUuid());

        ComplaintComment one = complaintCommentService.queryById(complaintComment.getUuid());
        return new Result<ComplaintComment>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ComplaintComment> add(@RequestBody ComplaintComment complaintComment) {
        log.info("新增,complaintComment={}", complaintComment);

        ComplaintComment one = complaintCommentService.insert(complaintComment);
        return new Result<ComplaintComment>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ComplaintComment> update(@RequestBody ComplaintComment complaintComment) {
        log.info("修改,complaintComment={}", complaintComment);

        ComplaintComment one = complaintCommentService.update(complaintComment);
        return new Result<ComplaintComment>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<ComplaintComment> queryAll(@RequestBody ComplaintComment complaintComment) {
        log.info("分页查询,complaintComment={}", complaintComment);

        Page<ComplaintComment> one = complaintCommentService.queryAll(complaintComment);
        PageInfo<ComplaintComment> pageinfo = new PageInfo<>(one);
        return new ResultForPage<ComplaintComment>(BusinessStatus.SUCCESS,pageinfo);
    }

}