package com.xl.backen.service;

import java.util.List;

import com.xl.backen.entity.Menus;

public interface MenusService {
	List<Menus> queryAll();

	/**
	 * 根绝角色id找到菜单
	 */
	List<Menus> findByRoleId(String roleId);
}
