package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Posts;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * 帖子相关
 */

@RestController
@RequestMapping("/post")
public class PostsController {
    @Autowired
    private PostsService ps;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody @Valid Posts posts) {
        ps.add(posts);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody @Valid Posts posts) {
        ps.update(posts);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/thumb", method = RequestMethod.POST)
    public Result<Object> thumb(@RequestBody @Valid Posts posts) {
        return new Result<>(BusinessStatus.SUCCESS,ps.thumbsUp(posts));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResultForPage<Posts> query(@RequestBody @Valid Map<String,Object> map) {
        Page<Posts> postsPage = ps.queryAll(map);
        PageInfo<Posts> postsPageInfo = new PageInfo<>(postsPage);
        return new ResultForPage<>(BusinessStatus.SUCCESS,postsPageInfo);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Posts> queryOne(@RequestBody Map<String,String> map) {
        Posts posts = ps.queryOne(map.get("uuid"));
        return new Result<>(BusinessStatus.SUCCESS,posts);
    }
}
