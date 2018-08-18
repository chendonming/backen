package com.xl.backen.service.impl;

import java.util.List;

import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.model.RolesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xl.backen.dao.UsersRoleMapper;
import com.xl.backen.entity.UsersRole;
import com.xl.backen.service.UsersRoleService;

@Service
@CacheConfig(cacheNames = "permiss")
public class UsersRoleServiceImpl implements UsersRoleService{

	@Autowired
	private UsersRoleMapper urm;

	@Autowired
	private UsersMapper um;
	
	/**
	 * 为用户分配角色
	 */
	@Override
	@Transactional
	@CacheEvict(allEntries=true)
	public int allocationRole(UsersRole ur) {

		Users users = new Users();
		users.setUuid(ur.getUserId());
		users.setRoleId(ur.getRoleId());

		um.updateByPrimaryKeySelective(users);
		return 1;
	}

	/**
	 * 查询角色下的所有用户
	 * @param roleId
	 * @return
	 */
	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public List<Users> findByRoleId(String roleId) {
		RolesModel rolesModel = urm.findByRoleId(roleId);
		if(rolesModel != null) {
			return rolesModel.getUsers();
		}else{
			return null;
		}
	}
}
