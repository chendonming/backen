package com.xl.backen.service;

import java.util.List;

import com.xl.backen.entity.UsersRole;

public interface UsersRoleService {
	/**
	 * 为用户分配角色
	 * @param record
	 * @return
	 */
	int allocationRole(List<UsersRole> ur);
}
