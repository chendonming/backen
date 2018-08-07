package com.xl.backen.service;

import java.util.List;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Powers;
import com.xl.backen.entity.RolesPower;

public interface PowersService {
	List<Powers> queryAll();

	/**
	 * 根据角色id找到所有的rolesPower
	 */
	List<Powers> queryByRoleId(String roleId);

	/**
	 * 根据角色id找到所有的菜单（包括最外层菜单）
	 */
	List<ParentMenus> queryParentMenusByRoleId(String roleId);
	
	/**
	 * 找到所有的菜单
	 */
	List<ParentMenus> queryParentMenus();
}
