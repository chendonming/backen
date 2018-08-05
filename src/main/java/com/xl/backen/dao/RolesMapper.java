package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Roles;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
    
    Page<Roles> queryAll(String sysType);
}