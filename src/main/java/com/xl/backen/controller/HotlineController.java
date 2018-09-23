package com.xl.backen.controller;

import com.xl.backen.entity.Hotline;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.HotlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/hotline")
public class HotlineController {
    private static Logger log = LoggerFactory.getLogger(HotlineController.class);

    @Autowired
    private HotlineService ho;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Hotline> add(@RequestBody @Valid Hotline hotline) {
        ho.add(hotline);
        return new Result<>(BusinessStatus.SUCCESS, hotline);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Hotline hotline) {
        log.info("热线修改，参数notices={}", hotline);
        ho.update(hotline);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Hotline> queryOne(@RequestBody @Valid Map<String, Object> map) {
        Hotline hotline = ho.queryOne((String) map.get("uuid"));
        return new Result<>(BusinessStatus.SUCCESS, hotline);
    }

}
