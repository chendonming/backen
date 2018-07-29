package com.xl.backen.service;

import java.util.List;

import com.xl.backen.entity.Roles;

public interface RolesService {
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	int insertSelective(Roles role);
	
	List<Roles> queryAll();
}
