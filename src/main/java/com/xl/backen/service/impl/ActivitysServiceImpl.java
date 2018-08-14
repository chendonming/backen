package com.xl.backen.service.impl;

import java.util.Date;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ActivitysMapper;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.service.ActivitysService;
import com.xl.backen.util.TimeUtil;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ActivitysServiceImpl
 */
@Service
public class ActivitysServiceImpl implements ActivitysService {
	@Autowired
	private ActivitysMapper as;

	@Override
	@Transactional
	public int add(Activitys activitys) {
		activitys.setUuid(UUID.randomUUID().toString().replace("-", ""));

		Users usersModel = (Users) SecurityUtils.getSubject().getPrincipal();
		String uuid = usersModel.getUuid();
		activitys.setCreateUser(uuid);

		Date sDate = activitys.getStartTime();
		Date eDate = activitys.getEndTime();
		Date jsdDate = activitys.getJoinStartTime();
		Date jseDate = activitys.getJoinEndTime();
		TimeUtil.volidTime(jsdDate, jseDate);
		TimeUtil.volidTime(sDate, eDate);
		activitys.setStatus(CommonConst.NORMAL_STATUS);

		activitys.setCreateTime(new Date());
		activitys.setUpdateTime(new Date());
		return as.insertSelective(activitys);
	}

	@Override
	public Page<Activitys> query(ActivitysPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());

		Users users = (Users) SecurityUtils.getSubject().getPrincipal();
		model.setCommunityId(users.getCommunityId());
		model.setSysType(users.getSysType());

		Page<Activitys> activitys = as.query(model);
		for (Activitys i : activitys) {
			int flag = TimeUtil.compareTime(i.getStartTime(), i.getEndTime(), i.getJoinStartTime(), i.getJoinEndTime());
			i.setFlag(flag);
		}
		return activitys;
	}

	@Override
	public int update(Activitys tasks) {
		return as.updateByPrimaryKeySelective(tasks);
	}

	@Override
	public Activitys findById(String uuid) {
		Activitys activitys = as.selectByPrimaryKey(uuid);
		int flag = TimeUtil.compareTime(activitys.getStartTime(), activitys.getEndTime(), activitys.getJoinStartTime(),
				activitys.getJoinEndTime());
		activitys.setFlag(flag);
		return activitys;
	}
}