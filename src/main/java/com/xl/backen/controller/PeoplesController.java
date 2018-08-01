package com.xl.backen.controller;

import java.io.IOException;
import java.util.List;

import com.github.pagehelper.Page;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.PeoplesPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.PeoplesService;

/**
 * 居民管理
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/people")
public class PeoplesController {
    @Autowired
    private PeoplesService ps;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Peoples pe) {
        ps.add(pe);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryByExport", method = RequestMethod.GET)
    public Result exportPeople() throws IOException {
        String file = ps.exportPeople();
        return new Result(BusinessStatus.SUCCESS, file);
    }

    @RequestMapping(value = "/addByImport", method = RequestMethod.POST)
    public Result importPeople(@RequestParam("file") MultipartFile file) throws Exception {
        ps.importPeople(file);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResultForPage query(@RequestBody PeoplesPageModel model) {
        Page<Peoples> peoples = ps.query(model);
        PageInfo<Peoples> peoplesPageInfo = new PageInfo<Peoples>(peoples);
        return new ResultForPage(BusinessStatus.SUCCESS, peoplesPageInfo);
    }

}
