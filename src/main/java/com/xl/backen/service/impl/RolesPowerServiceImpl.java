package com.xl.backen.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.xl.backen.dao.PowersMapper;
import com.xl.backen.entity.Powers;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.model.RolesPowerModel;
import com.xl.backen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xl.backen.dao.RolesPowerMapper;
import com.xl.backen.entity.RolesPower;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.RolesPowerService;

@Service
public class RolesPowerServiceImpl implements RolesPowerService{
	@Autowired
	private PowersMapper pm;

	@Autowired
	private RolesPowerMapper rpm;

	/**
	 * 赋权操作
	 */
	@Override
	@Transactional
	public int givePermiss(RolesPowerModel model) throws Exception{
		if(StringUtil.isEmpty(model.getRoleId())) {
			throw new BusinessException(BusinessStatus.PARAMETER_ERROR);
		}

		String roleId = model.getRoleId();

		//数据库的powersList
		List<Powers> powers = pm.queryByRoleId(model.getRoleId());

		List<String> powersList = new ArrayList<>();
		for(Powers p : powers) {
			powersList.add(p.getUuid());
		}

		//客户端传过来的powersList
		List<String> clientPowers = model.getPowers();

		for(String p : clientPowers) {
			List<String> list = new ArrayList<>();
			list.add(p);
			list.retainAll(powersList);

			if(list == null || list.size() == 0) {
				//没有结果，则新增
				RolesPower rp = new RolesPower();
				rp.setUuid(UUID.randomUUID().toString().replace("-",""));
				rp.setPowerId(p);
				rp.setRoleId(roleId);
				rp.setStatus(CommonConst.NORMAL_STATUS);
				rpm.insertSelective(rp);
			}
		}

		for(String p : powersList) {
			List<String> list = new ArrayList<>();
			list.add(p);
			list.retainAll(clientPowers);

			if(list == null || list.size() == 0) {
				rpm.delByUserAndRole(p,roleId);
			}

		}

		return 1;
	}
}
