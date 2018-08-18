package com.xl.backen.controller;

import com.xl.backen.entity.GarbageRule;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.GarbageRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garbage")
public class GarbageRuleController {
    @Autowired
    private GarbageRuleService grs;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody GarbageRule gr) {
        grs.insertSelective(gr);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody GarbageRule gr) {
        grs.updateByPrimaryKeySelective(gr);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<GarbageRule> queryOne(@RequestParam("sysType") String sysType) {
        System.out.println(sysType);
        GarbageRule rg = grs.findBy(sysType);
        return new Result<GarbageRule>(BusinessStatus.SUCCESS, rg);
    }
}
