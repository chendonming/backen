package com.xl.backen.dao;

import com.xl.backen.entity.Menus;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MenusMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);
    
    List<Menus> queryAll();

    /**
     * 根据角色id查找菜单
     */
    List<Menus> findByRoleId(String roleId);
}