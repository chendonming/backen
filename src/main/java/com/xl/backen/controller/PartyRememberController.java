package com.xl.backen.controller;

import com.xl.backen.entity.PartyRemember;
import com.xl.backen.service.PartyRememberService;
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
 * 党员信息表(TbPartyRemember)表控制层
 *
 * @author chendm
 * @since 2018-11-15 00:20:59
 */
@RestController
@RequestMapping("/partyRemember")
public class PartyRememberController {
    private static Logger log = LoggerFactory.getLogger(PartyRememberController.class);

    /**
     * 服务对象
     */
    @Resource
    private PartyRememberService partyRememberService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<PartyRemember> queryOne(@RequestBody PartyRemember partyRemember) {
        log.info("查询单个,uuid={}", partyRemember.getUuid());

        PartyRemember one = partyRememberService.queryById(partyRemember.getUuid());
        return new Result<PartyRemember>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<PartyRemember> add(@RequestBody PartyRemember partyRemember) {
        log.info("新增,partyRemember={}", partyRemember);

        PartyRemember one = partyRememberService.insert(partyRemember);
        return new Result<PartyRemember>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<PartyRemember> update(@RequestBody PartyRemember partyRemember) {
        log.info("修改,partyRemember={}", partyRemember);

        PartyRemember one = partyRememberService.update(partyRemember);
        return new Result<PartyRemember>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<PartyRemember> queryAll(@RequestBody PartyRemember partyRemember) {
        log.info("分页查询,partyRemember={}", partyRemember);

        Page<PartyRemember> one = partyRememberService.queryAll(partyRemember);
        PageInfo<PartyRemember> pageinfo = new PageInfo<>(one);
        return new ResultForPage<PartyRemember>(BusinessStatus.SUCCESS,pageinfo);
    }

}