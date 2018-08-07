package com.xl.backen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.RolesPower;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.PowersMapper;
import com.xl.backen.entity.Powers;
import com.xl.backen.service.PowersService;

@Service
public class PowersServiceImpl implements PowersService {

	@Autowired
	private PowersMapper pm;
	
	@Override
	public List<Powers> queryAll() {

		Users users = (Users)SecurityUtils.getSubject().getPrincipal();

		Integer type = null;
		if(StringUtil.isEmpty(users.getCommunityId())) {
			type = CommonConst.BACKEN_TYPE;
		}else{
			type = CommonConst.COMMUNITY_TYPE;
		}
		return pm.queryAll(type);
	}

	@Override
	public List<Powers> queryByRoleId(String roleId) {
		Users users = (Users)SecurityUtils.getSubject().getPrincipal();

		Map map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("type", users.getLoginType());

		return pm.queryByRoleId(map);
	}

	/**
	 * 根据角色id查找parentMenus
	 * @param roleId
	 * @return
	 */
	@Override
	public List<ParentMenus> queryParentMenusByRoleId(String roleId) {
		Users users = (Users)SecurityUtils.getSubject().getPrincipal();

		Map map = new HashMap();
		map.put("roleId",roleId);
		map.put("type",users.getLoginType());

		return pm.queryParentMenusByRoleId(map);
	}

	@Override
	public List<ParentMenus> queryParentMenus() {
		Users users = (Users)SecurityUtils.getSubject().getPrincipal();
		System.out.println(users);
		return pm.queryParentMenus(users.getLoginType());
	}

}
