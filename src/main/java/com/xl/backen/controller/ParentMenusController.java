package com.xl.backen.controller;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.service.ParentMenusService;
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
 * 父级菜单表(TbParentMenus)表控制层
 *
 * @author chendm
 * @since 2018-10-12 20:08:58
 */
@RestController
@RequestMapping("/parentMenus")
public class ParentMenusController {
    private static Logger log = LoggerFactory.getLogger(ParentMenusController.class);

    /**
     * 服务对象
     */
    @Resource
    private ParentMenusService parentMenusService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<ParentMenus> queryOne(@RequestBody ParentMenus parentMenus) {
        log.info("查询单个,uuid={}", parentMenus.getUuid());

        ParentMenus one = parentMenusService.queryById(parentMenus.getUuid());
        return new Result<ParentMenus>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<ParentMenus> add(@RequestBody ParentMenus parentMenus) {
        log.info("新增,parentMenus={}", parentMenus);

        ParentMenus one = parentMenusService.insert(parentMenus);
        return new Result<ParentMenus>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ParentMenus> update(@RequestBody ParentMenus parentMenus) {
        log.info("修改,parentMenus={}", parentMenus);

        ParentMenus one = parentMenusService.update(parentMenus);
        return new Result<ParentMenus>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<ParentMenus> queryAll(@RequestBody ParentMenus parentMenus) {
        log.info("分页查询,parentMenus={}", parentMenus);

        Page<ParentMenus> one = parentMenusService.queryAll(parentMenus);
        PageInfo<ParentMenus> pageinfo = new PageInfo<>(one);
        return new ResultForPage<ParentMenus>(BusinessStatus.SUCCESS,pageinfo);
    }

}