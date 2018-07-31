package com.xl.backen.controller;

import javax.validation.Valid;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.service.ActivitysService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private static Logger log = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivitysService ts;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody @Valid Activitys tasks) {
        ts.add(tasks);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResultForPage query(@RequestBody @Valid ActivitysPageModel model) {
        Page<Activitys> tasks = ts.query(model);

        PageInfo<Activitys> info = new PageInfo<Activitys>(tasks);

        return new ResultForPage(BusinessStatus.SUCCESS,info);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody @Valid Activitys tasks) {
        if(tasks.getStatus() != null) {
            throw new BusinessException(BusinessStatus.DEL_OPEAR_ERROR);
        }
        ts.update(tasks);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public Result del(@RequestParam("uuid") String uuid) {
        Activitys t = new Activitys();
        t.setUuid(uuid);
        t.setStatus(CommonConst.DEL_STATUS);
        ts.update(t);
        return new Result(BusinessStatus.SUCCESS);
    }
}
