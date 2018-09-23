package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Complaint;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.service.ComplaintService;
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
@RequestMapping("/complaint")
public class ComplaintController  {
    private static Logger log = LoggerFactory.getLogger(ComplaintController.class);

    @Autowired
    private ComplaintService co;

    //查询全部
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result<Object> queryAll(@RequestBody @Valid Map<String, Object> map) {
        log.info("建议投诉查询，参数comploaint={}", map);
        Page<Complaint> complaints = co.queryAll(map);
        PageInfo<Complaint> complaintPageInfo = new PageInfo<>(complaints);
        return new Result<>(BusinessStatus.SUCCESS, complaintPageInfo);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Complaint> queryOne(@RequestBody @Valid Map<String, Object> map) {
        Complaint complaint = co.quertOne((String) map.get("uuid"));
        return new Result<>(BusinessStatus.SUCCESS, complaint);
    }

    //新增
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody @Valid Complaint complaint) {
        log.info("建议投诉新增，参数comploaint={}", complaint);
        co.add(complaint);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    //修改
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Complaint complaint) {
        log.info("建议投诉修改，参数comploaint={}", complaint);
        co.update(complaint);
        return new Result<>(BusinessStatus.SUCCESS);
    }

}
