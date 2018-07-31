package com.xl.backen.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.xl.backen.entity.Users;
import com.xl.backen.model.RolesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xl.backen.dao.UsersRoleMapper;
import com.xl.backen.entity.UsersRole;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.UsersRoleService;

@Service
public class UsersRoleServiceImpl implements UsersRoleService{

	@Autowired
	private UsersRoleMapper urm;
	
	/**
	 * 为用户分配角色
	 */
	@Override
	@Transactional
	public int allocationRole(List<UsersRole> ur) {
		if(ur != null) {
			String userId = ur.get(0).getUserId();
			String roleId = ur.get(0).getRoleId();
			
			List<UsersRole> urs = urm.queryByUserId(userId);
			
			Set<UsersRole> update = new HashSet<UsersRole>();
			Set<UsersRole> add = new HashSet<UsersRole>();
			Set<UsersRole> updateSetFalse = new HashSet<UsersRole>();
			
			 /**
			  * 去除所有角色
			  */
			 if(StringUtils.isEmpty(roleId)) {
				 updateSetFalse.addAll(urs);
				 for(UsersRole i : updateSetFalse) {
					 System.out.println("执行修改no:" + i);
					 if(i.getStatus() != CommonConst.DEL_STATUS) {
						 i.setStatus(CommonConst.DEL_STATUS);
						 urm.updateByPrimaryKeySelective(i);
					 }
				 }
				 return 1;
			 }
			 
			 
			 for(UsersRole i : ur) {
				 for(UsersRole j : urs) {
					 if(i.equals(j)) {
						 i.setUuid(j.getUuid());
						 i.setStatus(j.getStatus());
					 }
				 }
			 }
			 
			 
			 if(ur.size() <= urs.size()) {
				 List<UsersRole> i = new ArrayList<UsersRole>();
				 i.addAll(ur);
				 i.retainAll(urs);
				 update.addAll(i);
				 
				 if(update.size() == 0) {
					 //没有交集
					 add.addAll(ur);
					 updateSetFalse.addAll(urs);
				 }else {
					 i.clear();
					 i.addAll(urs);
					 i.removeAll(ur);
					 updateSetFalse.addAll(i);
				 }
			 }else {
				 List<UsersRole> i = new ArrayList<UsersRole>();
				 i.addAll(urs);
				 i.retainAll(ur);
				 update.addAll(i);
				 
				 if(update.size() == 0) {
					 //没有交集
					 add.addAll(ur);
					 updateSetFalse.addAll(urs);
				 }else {
					 i.clear();
					 i.addAll(ur);
					 i.removeAll(urs);
					 add.addAll(i);
				 }
			 }
			 
			 
			 for(UsersRole i : add) {
				 i.setStatus(CommonConst.NORMAL_STATUS);
				 i.setUuid(UUID.randomUUID().toString().replace("-", ""));
				 System.out.println("执行新增:" + i);
				 urm.insertSelective(i);
			 }
			 
			 
			 for(UsersRole i : update) {
				 System.out.println("修改:"+i);
				 if(i.getStatus() ==null || i.getStatus() != CommonConst.NORMAL_STATUS) {
					 i.setStatus(CommonConst.NORMAL_STATUS);
					 System.out.println("执行修改:" + i);
					 urm.updateByPrimaryKeySelective(i);
				 }
			 }
			 
			 for(UsersRole i : updateSetFalse) {
				 System.out.println("执行修改no:" + i);
				 if(i.getStatus() == null || i.getStatus() != CommonConst.DEL_STATUS) {
					 System.out.println("执行修改no:" + i);
					 i.setStatus(CommonConst.DEL_STATUS);
					 System.out.println("执行修改no:" + i);
					 urm.updateByPrimaryKeySelective(i);
				 }
			 }
		}
		return 1;
	}

	/**
	 * 查询角色下的所有用户
	 * @param roleId
	 * @return
	 */
	@Override
	public List<Users> findByRoleId(String roleId) {
		RolesModel rolesModel = urm.findByRoleId(roleId);
		if(rolesModel != null) {
			return rolesModel.getUsers();
		}else{
			return null;
		}
	}
}
