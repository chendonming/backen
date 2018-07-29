package com.xl.backen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    private static Logger log = LoggerFactory.getLogger(TaskController.class);


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String login() {
        return "task查询接口";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "task新增接口";
    }
    
    @RequestMapping(value = "/addByUser", method = RequestMethod.GET)
    public String add1() {
        return "task新增User接口";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        return "task修改接口";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() {
        return "task删除接口";
    }
}
