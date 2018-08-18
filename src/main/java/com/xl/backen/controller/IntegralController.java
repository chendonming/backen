package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/integral")
public class IntegralController {
    @Autowired
    private IntegralService is;

    @RequestMapping(value = "/distribute", method = RequestMethod.POST)
    public Result<Object> queryAct(@RequestBody PeoplesIntegralInt pil) {
        is.distribute(pil);
        return new Result(BusinessStatus.SUCCESS);
    }
}
