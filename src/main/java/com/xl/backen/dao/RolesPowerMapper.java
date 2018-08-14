package com.xl.backen.dao;

import com.xl.backen.entity.RolesPower;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesPowerMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RolesPower record);

    int insertSelective(RolesPower record);

    RolesPower selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RolesPower record);

    int updateByPrimaryKey(RolesPower record);
    
    /**
     * 根据角色id找到所有的rolesPower
     */
    List<RolesPower> queryByRoleId(String roleId);

    /**
     * 根据userId  roleId进行删除
     */
    int delByUserAndRole(Map<String,String> map);
}