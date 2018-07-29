package com.xl.backen.service;

import java.util.List;

import com.xl.backen.entity.RolesPower;

public interface RolesPowerService {
	int givePermiss(List<RolesPower> record) throws Exception;
	
	/**
     * 根据角色id找到所有的rolesPower
     */
    List<RolesPower> queryByRoleId(String roleId);
}
