package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.service.CircleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/circle")
public class CircleController {
    private static Logger log = LoggerFactory.getLogger(CircleController.class);

    @Autowired
    private CircleService cs;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result query(@RequestBody Map<String, Object> map) {
        Page<Circle> circlePage = cs.query(map);
        PageInfo<Circle> pageInfo = new PageInfo<>(circlePage);
        return new Result(BusinessStatus.SUCCESS, pageInfo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody @Valid Circle circle) {
        log.info("圈子新增，参数circle={}", circle);
        cs.add(circle);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Circle circle){
        log.info("圈子修改，参数circle={}", circle);
        cs.update(circle);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Result<Object> del(@RequestBody @Valid Circle circle){
        log.info("圈子删除，参数circle={}", circle);
        cs.update(circle);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Object> queryOne(@RequestBody @Valid Circle circle) {
        log.info("圈子单个查询，参数circle={}", circle);
        Circle circle1 = cs.queryOne(circle);
        return new Result(BusinessStatus.SUCCESS, circle1);
    }

}
