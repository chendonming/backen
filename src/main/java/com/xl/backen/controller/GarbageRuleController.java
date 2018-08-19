package com.xl.backen.controller;

import com.xl.backen.entity.GarbageRule;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.GarbageRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garbage")
public class GarbageRuleController {
    private static Logger log = LoggerFactory.getLogger(GarbageRuleController.class);

    @Autowired
    private GarbageRuleService grs;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody GarbageRule gr) {
        log.info( "垃圾分类新增: gr={}",gr);
        grs.insertSelective(gr);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody GarbageRule gr) {
        log.info("垃圾分类修改,gr={}", gr);
        grs.updateByPrimaryKeySelective(gr);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<GarbageRule> queryOne(@RequestParam("sysType") String sysType) {
        log.info("垃圾分类查询单个,sysType= {}",sysType);
        GarbageRule rg = grs.findBy(sysType);
        return new Result<GarbageRule>(BusinessStatus.SUCCESS, rg);
    }
}
