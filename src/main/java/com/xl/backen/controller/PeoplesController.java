package com.xl.backen.controller;

import java.io.IOException;

import com.github.pagehelper.Page;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.PeoplesPageModel;
import com.xl.backen.service.WxUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger log = LoggerFactory.getLogger(PeoplesController.class);

    @Autowired
    private PeoplesService ps;

    @Autowired
    private WxUsersService uss;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody Peoples pe) {
        log.info("居民新增: peoples={}",pe);
        ps.add(pe);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody Peoples pe) {
        log.info("居民修改: peoples={}",pe);
        ps.update(pe);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryByExport", method = RequestMethod.GET)
    public Result<String> exportPeople() throws IOException {
        log.info("居民导出----------------");
        String file = ps.exportPeople();
        return new Result<String>(BusinessStatus.SUCCESS, file);
    }

    @RequestMapping(value = "/addByImport", method = RequestMethod.POST)
    public Result<String> importPeople(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("居民导入---------------");
        int count = ps.importPeople(file);
        return new Result<String>(BusinessStatus.SUCCESS, count + "条记录改变");
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResultForPage<Peoples> query(@RequestBody PeoplesPageModel model) {
        Page<Peoples> peoples = ps.query(model);
        PageInfo<Peoples> peoplesPageInfo = new PageInfo<Peoples>(peoples);
        return new ResultForPage<Peoples>(BusinessStatus.SUCCESS, peoplesPageInfo);
    }


    /**
     * APP实名认证
     * @param
     * @return
     */
    @RequestMapping(value = "/verified", method = RequestMethod.POST)
    public Result<Object> verified(@RequestBody Peoples peoples){
        uss.authentication(peoples);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    /**
     * 根据peoples查询剩余积分
     * @param
     * @return
     */
    @RequestMapping(value = "/queryIntegral", method = RequestMethod.GET)
    public Result<Object> queryIntegral(@RequestParam("peopleId") String peopleId){
        return new Result<>(BusinessStatus.SUCCESS,ps.queryIntegral(peopleId));
    }

    /**
     * 查询单个
     * @param
     * @return
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<Object> queryOne(@RequestParam("peopleId") String peopleId){
        return new Result<>(BusinessStatus.SUCCESS,ps.queryOne(peopleId));
    }

}
