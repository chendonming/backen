package com.xl.backen.controller;

import com.xl.backen.entity.CirclePostComment;
import com.xl.backen.service.CirclePostCommentService;
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
 * (TbCirclePostComment)表控制层
 *
 * @author chendm
 * @since 2018-10-04 16:07:42
 */
@RestController
@RequestMapping("/circlePostComment")
public class CirclePostCommentController {
    private static Logger log = LoggerFactory.getLogger(CirclePostCommentController.class);

    /**
     * 服务对象
     */
    @Resource
    private CirclePostCommentService circlePostCommentService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<CirclePostComment> queryOne(@RequestBody CirclePostComment circlePostComment) {
        log.info("查询单个,uuid={}", circlePostComment.getUuid());

        CirclePostComment one = circlePostCommentService.queryById(circlePostComment.getUuid());
        return new Result<CirclePostComment>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<CirclePostComment> add(@RequestBody CirclePostComment circlePostComment) {
        log.info("新增,circlePostComment={}", circlePostComment);

        CirclePostComment one = circlePostCommentService.insert(circlePostComment);
        return new Result<CirclePostComment>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<CirclePostComment> update(@RequestBody CirclePostComment circlePostComment) {
        log.info("修改,circlePostComment={}", circlePostComment);

        CirclePostComment one = circlePostCommentService.update(circlePostComment);
        return new Result<CirclePostComment>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<CirclePostComment> queryAll(@RequestBody CirclePostComment circlePostComment) {
        log.info("分页查询,circlePostComment={}", circlePostComment);

        Page<CirclePostComment> one = circlePostCommentService.queryAll(circlePostComment);
        PageInfo<CirclePostComment> pageinfo = new PageInfo<>(one);
        return new ResultForPage<CirclePostComment>(BusinessStatus.SUCCESS,pageinfo);
    }

}