package com.xl.backen.dao;

import com.xl.backen.entity.UsersRole;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UsersRoleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UsersRole record);

    int insertSelective(UsersRole record);

    UsersRole selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UsersRole record);

    int updateByPrimaryKey(UsersRole record);
    
    /**
     * 根据roleid,userid找到对象
     */
    UsersRole findByRoleAndUser(UsersRole ur);
    /**
     * 根据userId找到List对象
     */
    List<UsersRole> queryByUserId(String userId);
}