package com.xl.backen.dao;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Powers;

import com.xl.backen.entity.RolesPower;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PowersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Powers record);

    int insertSelective(Powers record);

    Powers selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Powers record);

    int updateByPrimaryKey(Powers record);
    
    List<Powers> queryAll(Integer type);

    List<Powers> queryByRoleId(Map map);

    List<ParentMenus> queryParentMenusByRoleId(Map map);
    
    List<ParentMenus> queryParentMenus(Integer type);
}