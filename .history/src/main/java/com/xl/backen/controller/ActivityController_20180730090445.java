package com.xl.backen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private static Logger log = LoggerFactory.getLogger(ActivityController.class);

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query() {
        return "activity查询接口";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "activity新增接口";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        return "activity修改接口";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() {
        return "activity删除接口";
    }
}
