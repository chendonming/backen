package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CommunitysMapper;
import com.xl.backen.entity.Communitys;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.CommunitysPageModel;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.CommunitysService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class CommunitysServiceImpl implements CommunitysService {

	@Autowired
	private CommunitysMapper cm;

	@Override
	public int add(Communitys communitys) {
		UsersModel model = (UsersModel) SecurityUtils.getSubject().getPrincipal();

		communitys.setUuid(UUID.randomUUID().toString().replace("-", ""));
		communitys.setStatus(CommonConst.NORMAL_STATUS);
		communitys.setCreateTime(new Date());
		communitys.setUpdateTime(new Date());

		communitys.setCreateUser(model.getUuid());
		return cm.insertSelective(communitys);
	}

	@Override
	public int update(Communitys communitys) {
		if(StringUtils.isEmpty(communitys.getUuid())) {
			throw new BusinessException(BusinessStatus.UUID_REQ);
		}
		return cm.updateByPrimaryKeySelective(communitys);
	}

	@Override
	public Page<Communitys> query(CommunitysPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());
		Page<Communitys> communitys = cm.query(model);
		return communitys;
	}

	@Override
	public Communitys findById(String uuid) {
		if(StringUtils.isEmpty(uuid)) {
			throw new BusinessException(BusinessStatus.UUID_REQ);
		}
		return cm.selectByPrimaryKey(uuid);
	}
}
