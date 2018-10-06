package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Posts;
import com.xl.backen.model.PostModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PostsMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Posts record);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKey(Posts record);

    /**
     * 分页查询我的点赞帖子
     * @param peopleId
     * @return
     */
    Page<Posts> queryMyThumbPosts(@Param(value="uuid")String peopleId);


    /**
     * 分页查询所有帖子
     * @param map { pageSize pageNum circleId }
     * @return
     */
    Page<Posts> queryPosts(Map<String,Object> map);

    /**
     * 查询单个帖子
     * @param uuid
     * @return
     */
    PostModel queryOne(String uuid);

    /**
     * 查询单个帖子的点赞数量
     * @return
     */
    Integer thumbCount(@Param(value = "uuid") String uuid);

    /**
     * 查询单个帖子的评论数量
     * @return
     */
    Integer commentCount(@Param(value = "uuid") String uuid);
}