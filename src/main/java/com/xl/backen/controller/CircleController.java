package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/circle")
public class CircleController {
    @Autowired
    private CircleService cs;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result query(@RequestBody Map<String, Object> map) {
        Page<Circle> circlePage = cs.query(map);
        PageInfo<Circle> pageInfo = new PageInfo<>(circlePage);
        return new Result(BusinessStatus.SUCCESS, pageInfo);
    }
}
