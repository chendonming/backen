package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ActivitysMapper;
import com.xl.backen.dao.ActivitysPeoplesMapper;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.ActivitysPeoples;
import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.model.*;
import com.xl.backen.service.AppActivitysService;
import com.xl.backen.util.StringUtil;
import com.xl.backen.util.TimeUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AppActivitysServiceImpl implements AppActivitysService {
	@Autowired
	private ActivitysMapper as;

	@Autowired
	private ActivitysPeoplesMapper apm;

	@Override
	public Page<Activitys> query(ActivitysPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());

		Peoples users = (Peoples) SecurityUtils.getSubject().getPrincipal();
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
	public int joinAct(String actId) {
		if (StringUtil.isEmpty(actId)) {
			throw new BusinessException(BusinessStatus.UUID_REQ);
		}

		ActivitysPeoples ap = new ActivitysPeoples();
		ap.setCreateTime(new Date());
		ap.setUpdateTime(new Date());
		ap.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
		ap.setActivityId(actId);
		ap.setUuid(UUID.randomUUID().toString().replace("-", ""));

		int count = apm.insertSelective(ap);
		if (count <= 0) {
			throw new BusinessException(BusinessStatus.INSERT_ERROR);
		}

		// 根据任务id进行修改
		synchronized (ap) {
			Activitys act = as.selectByPrimaryKey(actId);

			int joinPeople = act.getJoinPeople() == null ? 0 : act.getJoinPeople();

			act.setJoinPeople(joinPeople + 1);

			count = as.updateByPrimaryKeySelective(act);

			if (count <= 0) {
				throw new BusinessException(BusinessStatus.UPDATE_ERROR);
			}
		}
		
		return 1;
	}

	@Override
	public Page<Activitys> findByPeople(ActivitysPeopleModel ap) {
		if (ap.getPageNum() != null && ap.getPageSize() != null) {
			PageHelper.startPage(ap.getPageNum(), ap.getPageSize());
		}

		ap.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());

		return apm.findByPeople(ap);
	}

	@Override
	public Page<Peoples> findByActId(ActivitysPeopleModel ap) {
		if (ap.getPageNum() != null && ap.getPageSize() != null) {
			PageHelper.startPage(ap.getPageNum(), ap.getPageSize());
		}
		return apm.findByActId(ap);
	}

	@Override
	public AppActivitysModel findOne(String actId) {
		AppActivitysModel activitysModel = as.findOne(actId);

		Map<String, String> map = new HashMap<>();
		map.put("peopleId", ((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
		map.put("actId", actId);
		int i = apm.exist(map);

		if (i > 0) {
			activitysModel.setIs_join_act(true);
		} else {
			activitysModel.setIs_join_act(false);
		}

		int f = TimeUtil.compareTime(activitysModel.getJoinStartTime(), activitysModel.getJoinEndTime(),
				activitysModel.getStartTime(), activitysModel.getEndTime());

		activitysModel.setFlag(f);

		return activitysModel;
	}
}
