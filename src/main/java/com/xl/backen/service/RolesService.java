package com.xl.backen.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Roles;
import com.xl.backen.model.UsersPageModel;

import javax.management.relation.Role;

public interface RolesService {
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	int insertSelective(Roles role);
	
	Page<Roles> queryAll(UsersPageModel model);

	/**
	 * 修改
	 */
	int updateRole(Roles role);

	Roles findById(Roles roles);
}
