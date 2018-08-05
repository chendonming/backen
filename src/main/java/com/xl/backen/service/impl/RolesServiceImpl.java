package com.xl.backen.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.model.UsersModel;
import com.xl.backen.model.UsersPageModel;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.RolesMapper;
import com.xl.backen.entity.Roles;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesMapper rm;
	
	@Override
	public int insertSelective(Roles role) {
		Date d = new Date();
		UsersModel usersModel = (UsersModel)SecurityUtils.getSubject().getPrincipal();

		role.setUuid(UUID.randomUUID().toString().replace("-", ""));
		role.setCreateTime(d);
		role.setUpdateTime(d);
		role.setSysType(usersModel.getSysType());

		int i = rm.insertSelective(role);
		if(i > 0) {
			return i;
		}else {
			throw new BusinessException(BusinessStatus.INSERT_ERROR);
		}
	}

	@Override
	public Page<Roles> queryAll(UsersPageModel model) {

		UsersModel usersModel = (UsersModel)SecurityUtils.getSubject().getPrincipal();

		PageHelper.startPage(model.getPageNum(),model.getPageSize());

		return rm.queryAll(usersModel.getSysType());
	}

	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@Override
	public int updateRole(Roles role) {
		return rm.updateByPrimaryKeySelective(role);
	}

	@Override
	public Roles findById(Roles roles) {
		return rm.selectByPrimaryKey(roles.getUuid());
	}
}
