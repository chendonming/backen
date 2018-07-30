package com.xl.backen.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xl.backen.config.UserRealm;
import com.xl.backen.dao.RolesPowerMapper;
import com.xl.backen.entity.RolesPower;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.RolesPowerService;

@Service
public class RolesPowerServiceImpl implements RolesPowerService{
	@Autowired
	private RolesPowerMapper rpm;
	
	/**
	 * 赋权操作
	 */
	@Override
	@Transactional
	public int givePermiss(List<RolesPower> rp) throws Exception{
		if(rp != null) {
			 String roleId = rp.get(0).getRoleId();
			 String powerId = rp.get(0).getPowerId();
			 List<RolesPower> rps = queryByRoleId(roleId);
			 
			 Set<RolesPower> update = new HashSet<RolesPower>();
			 Set<RolesPower> updateSetFalse = new HashSet<RolesPower>();
			 Set<RolesPower> add = new HashSet<RolesPower>();
			 
			 /**
			  * 去除所有权限
			  */
			 if(StringUtils.isEmpty(powerId)) {
				 updateSetFalse.addAll(rps);
				 for(RolesPower i : updateSetFalse) {
					 System.out.println("执行修改no:" + i);
					 if(i.getStatus() != CommonConst.DEL_STATUS) {
						 i.setStatus(CommonConst.DEL_STATUS);
						 rpm.updateByPrimaryKeySelective(i);
					 }
				 }
				 return 1;
			 }
			 
			 for(RolesPower i : rp) {
				 for(RolesPower j : rps) {
					 if(j.equals(j)) {
						 i.setUuid(j.getUuid());
						 i.setStatus(j.getStatus());
					 }
				 }
			 }
			 
			 if(rp.size() <= rps.size()) {
				 List<RolesPower> i = new ArrayList<RolesPower>();
				 i.addAll(rp);
				 i.retainAll(rps);
				 update.addAll(i);
				 
				 if(update.size() == 0) {
					 //没有交集
					 add.addAll(rp);
					 updateSetFalse.addAll(rps);
				 }else {
					 i.clear();
					 i.addAll(rps);
					 i.removeAll(rp);
					 updateSetFalse.addAll(i);
				 }
			 }else {
				 List<RolesPower> i = new ArrayList<RolesPower>();
				 i.addAll(rps);
				 i.retainAll(rp);
				 update.addAll(i);
				 
				 if(update.size() == 0) {
					 //没有交集
					 add.addAll(rp);
					 updateSetFalse.addAll(rps);
				 }else {
					 i.clear();
					 i.addAll(rp);
					 i.removeAll(rps);
					 add.addAll(i);
				 }
			 }
			 
			 for(RolesPower i : add) {
				 i.setStatus(CommonConst.NORMAL_STATUS);
				 i.setUuid(UUID.randomUUID().toString().replace("-", ""));
				 System.out.println("执行新增:" + i);
				 rpm.updateByPrimaryKeySelective(i);
			 }
			 
			 
			 for(RolesPower i : update) {
				 if(i.getStatus() ==null || i.getStatus() != CommonConst.NORMAL_STATUS) {
					 i.setStatus(CommonConst.NORMAL_STATUS);
					 System.out.println("执行修改:" + i);
					 rpm.updateByPrimaryKeySelective(i);
				 }
			 }
			 
			 for(RolesPower i : updateSetFalse) {
				 System.out.println("执行修改no:" + i);
				 if(i.getStatus() == null || i.getStatus() != CommonConst.DEL_STATUS) {
					 System.out.println("执行修改no:" + i);
					 i.setStatus(CommonConst.DEL_STATUS);
					 System.out.println("执行修改no:" + i);
					 rpm.updateByPrimaryKeySelective(i);
				 }
			 }
			 
		}
		return 1;
	}

	/**
	 * 根据角色id找到所有的rolesPower
	 */
	@Override
	public List<RolesPower> queryByRoleId(String roleId) {
		List<RolesPower> list = rpm.queryByRoleId(roleId);
		return list;
	}

}
