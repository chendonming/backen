package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.VolunteerModel;
import com.xl.backen.service.VolunteerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * VolunteerController
 */
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
  @Autowired
  private VolunteerService vs;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public Result<Object> add(@RequestBody VolunteerModel volunteerModel) {
    vs.add(volunteerModel);
    return new Result<>(BusinessStatus.SUCCESS);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Result<Object> update(@RequestBody VolunteerModel volunteerModel) {
    vs.update(volunteerModel);
    return new Result<>(BusinessStatus.SUCCESS);
  }

  @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
  public Result<Object> queryOne(@RequestBody VolunteerModel volunteerModel) {
    return new Result<>(BusinessStatus.SUCCESS, vs.queryOne(volunteerModel.getUuid()));
  }

  @RequestMapping(value = "/queryList", method = RequestMethod.POST)
  public ResultForPage<VolunteerModel> queryList(@RequestBody VolunteerModel volunteerModel) {
    Page<VolunteerModel> pModels = vs.queryList(volunteerModel);
    PageInfo<VolunteerModel> pageInfo = new PageInfo<>(pModels);
    return new ResultForPage<VolunteerModel>(BusinessStatus.SUCCESS, pageInfo);
  }

}