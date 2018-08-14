package com.xl.backen.service;


import com.github.pagehelper.Page;
import com.xl.backen.entity.Roles;


public interface RolesService {
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	int insertSelective(Roles role);
	
	Page<Roles> queryAll(int pageNum, int pageSize);

	/**
	 * 修改
	 */
	int updateRole(Roles role);

	Roles findById(Roles roles);
}
