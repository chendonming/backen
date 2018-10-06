package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Posts;
import com.xl.backen.model.PostModel;

import java.util.Map;

public interface PostsService {
    int add(Posts posts);

    int update(Posts posts);

    /**
     * 点赞帖子
     * @param posts
     * @return
     */
    Posts thumbsUp(Posts posts);

    /**
     * 分页查询帖子
     * @param map( pageSize, pageNum , circleId)
     * @return
     */
    Page<Posts> queryAll(Map<String,Object> map);

    /**
     * 查询帖子详情
     * @return
     */
    Posts queryOne(String uuid);
}
