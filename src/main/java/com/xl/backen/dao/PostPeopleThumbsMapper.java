package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.PostPeopleThumbs;
import com.xl.backen.entity.Posts;

import java.util.List;

public interface PostPeopleThumbsMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PostPeopleThumbs record);

    int insertSelective(PostPeopleThumbs record);

    PostPeopleThumbs selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PostPeopleThumbs record);

    int updateByPrimaryKey(PostPeopleThumbs record);

    /**
     * 判断是否点赞
     * @param postPeopleThumbs
     * @return
     */
    List<PostPeopleThumbs> queryByPeopleAndPost(PostPeopleThumbs postPeopleThumbs);
}