package com.xl.backen.controller;

import com.xl.backen.entity.Articles;
import com.xl.backen.service.ArticlesService;
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
 * 文章表(TbArticles)表控制层
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
@RestController
@RequestMapping("/articles")
public class ArticlesController {
    private static Logger log = LoggerFactory.getLogger(ArticlesController.class);

    /**
     * 服务对象
     */
    @Resource
    private ArticlesService articlesService;

    
    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Articles> queryOne(@RequestBody Articles articles) {
        log.info("查询单个,uuid={}", articles.getUuid());

        Articles one = articlesService.queryById(articles.getUuid());
        return new Result<Articles>(BusinessStatus.SUCCESS, one);
    }


     /**
     * 新增
     * @param 实体类
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Articles> add(@RequestBody Articles articles) {
        log.info("新增,articles={}", articles);

        Articles one = articlesService.insert(articles);
        return new Result<Articles>(BusinessStatus.SUCCESS,one);
    }


     /**
     * 修改
     * @param 实体类
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Articles> update(@RequestBody Articles articles) {
        log.info("修改,articles={}", articles);

        Articles one = articlesService.update(articles);
        return new Result<Articles>(BusinessStatus.SUCCESS,one);
    }


    /**
     * 分页查询
     * @param 实体类
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultForPage<Articles> queryAll(@RequestBody Articles articles) {
        log.info("分页查询,articles={}", articles);

        Page<Articles> one = articlesService.queryAll(articles);
        PageInfo<Articles> pageinfo = new PageInfo<>(one);
        return new ResultForPage<Articles>(BusinessStatus.SUCCESS,pageinfo);
    }

}