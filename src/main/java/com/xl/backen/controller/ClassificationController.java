package com.xl.backen.controller;

import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Classification;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    @Autowired
    private ClassificationService cs;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody @Valid Classification classification) {
        cs.add(classification);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Classification classification) {
        cs.update(classification);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public Result<Object> queryAll() {
        Classification classification = new Classification();
        return new Result<>(BusinessStatus.SUCCESS, cs.queryAll(classification));
    }

    @RequestMapping(value = "/queryByIf", method = RequestMethod.POST)
    public Result<Object> queryByIf(@RequestBody Classification classification) {
        return new Result<>(BusinessStatus.SUCCESS, cs.queryByIf(classification));
    }
}
