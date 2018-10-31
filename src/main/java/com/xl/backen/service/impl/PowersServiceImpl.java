package com.xl.backen.service.impl;

import java.util.*;

import com.xl.backen.dao.ParentMenusMapper;
import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.PowersMapper;
import com.xl.backen.entity.Powers;
import com.xl.backen.service.PowersService;

@Service
public class PowersServiceImpl implements PowersService {

	@Autowired
	private PowersMapper pm;

	@Autowired
	private ParentMenusMapper pmm;

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

		Map<String,Object> map = new HashMap<>();
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

		Map<String,Object> map = new HashMap<>();
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

	@Override
	public int insertPowers(Powers powers) {
			/* 主菜单 */
		if(powers.getMeunType() == 1) {
			ParentMenus parentMenus = new ParentMenus();
			parentMenus.setUuid(UUID.randomUUID().toString().replace("-", ""));
			parentMenus.setUpdateTime(new Date());
			parentMenus.setCreateTime(new Date());
			parentMenus.setCode(powers.getCode());
			parentMenus.setMeunName(powers.getMeunName());
			parentMenus.setWeight(powers.getWeight());
			/* 设置为2 ： 社区 */
			parentMenus.setType(2);
			parentMenus.setName(powers.getMeunName());

			pmm.insert(parentMenus);
		}else{
			/* 次级菜单 */
			powers.setUuid(UUID.randomUUID().toString().replace("-", ""));
			powers.setUpdateTime(new Date());
			powers.setCreateTime(new Date());
			/* 直接设置为 2： 社区type */
			powers.setType(2);

			pm.insertSelective(powers);
		}

		return 1;
	}

	@Override
	public int updatePowers(Powers powers) {
		if(powers.getMeunType() == 1) {
			ParentMenus parentMenus = new ParentMenus();
			parentMenus.setUuid(powers.getUuid());
			parentMenus.setUpdateTime(new Date());
			parentMenus.setCreateTime(new Date());
			parentMenus.setCode(powers.getCode());
			parentMenus.setMeunName(powers.getMeunName());
			parentMenus.setWeight(powers.getWeight());
			parentMenus.setType(powers.getType());
			parentMenus.setName(powers.getMeunName());

			pmm.update(parentMenus);
		}else{
			powers.setUpdateTime(new Date());
			powers.setCreateTime(new Date());

			pm.updateByPrimaryKeySelective(powers);
		}
		return 0;
	}

	@Override
	public int delPowers(String uuid) {
		return pm.deleteByPrimaryKey(uuid);
	}

}
