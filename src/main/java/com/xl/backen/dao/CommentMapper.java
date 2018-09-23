package com.xl.backen.dao;

import com.xl.backen.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}