package com.xl.backen.controller;

import com.xl.backen.entity.Complaint;
import com.xl.backen.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.handler.BusinessStatus;

/**
 * 建议投诉(TbComplaint)表控制层
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    private static Logger log = LoggerFactory.getLogger(ComplaintController.class);

    /**
     * 服务对象
     */
    @Resource
    private ComplaintService complaintService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Complaint> queryOne(@RequestBody Complaint complaint) {
        log.info("查询单个,uuid={}", complaint.getUuid());

        Complaint one = complaintService.queryById(complaint.getUuid());
        return new Result<Complaint>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Complaint> add(@RequestBody Complaint complaint) {
        log.info("新增,complaint={}", complaint);

        Complaint one = complaintService.insert(complaint);
        return new Result<Complaint>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Complaint> update(@RequestBody Complaint complaint) {
        log.info("修改,complaint={}", complaint);

        Complaint one = complaintService.update(complaint);
        return new Result<Complaint>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Complaint> queryAll(@RequestBody Complaint complaint) {
        log.info("分页查询,complaint={}", complaint);

        Page<Complaint> one = complaintService.queryAll(complaint);
        PageInfo<Complaint> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Complaint>(BusinessStatus.SUCCESS,pageinfo);
    }

}