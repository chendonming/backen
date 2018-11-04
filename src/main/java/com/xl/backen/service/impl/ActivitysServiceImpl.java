package com.xl.backen.service.impl;

import java.util.Date;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ActivitysMapper;
import com.xl.backen.dao.ActivitysPeoplesMapper;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.ActivitysPeoples;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.model.ActivitysPeopleModel;
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

  @Autowired
  private ActivitysPeoplesMapper apm;

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
    TimeUtil.volidTime(sDate, eDate, jsdDate, jseDate);
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
      int flag = TimeUtil.compareTime(i.getJoinStartTime(), i.getJoinEndTime(), i.getStartTime(), i.getEndTime());
      i.setFlag(flag);
    }
    return activitys;
  }

  @Override
  public int update(Activitys tasks) {

    if (tasks.getStartTime() != null && tasks.getEndTime() != null &&
      tasks.getJoinStartTime() != null &&
      tasks.getJoinEndTime() != null
    ) {
      TimeUtil.compareTime(tasks.getJoinStartTime(), tasks.getJoinEndTime(), tasks.getStartTime(), tasks.getEndTime());
    }

    return as.updateByPrimaryKeySelective(tasks);
  }

  @Override
  public Activitys findById(String uuid) {
    Activitys activitys = as.selectByPrimaryKey(uuid);
    int flag = TimeUtil.compareTime(activitys.getJoinStartTime(), activitys.getJoinEndTime(), activitys.getStartTime(), activitys.getEndTime());
    activitys.setFlag(flag);
    return activitys;
  }

  @Override
  public Page<Peoples> findJoinPeoples(String uuid, Integer pageSize, Integer pageNum) {
    if (pageSize != null && pageNum != null) {
      PageHelper.startPage(pageSize, pageNum);
    }
    ActivitysPeopleModel ap = new ActivitysPeopleModel();
    ap.setActivityId(uuid);
    Page<Peoples> peoplesPage = apm.findByActId(ap);
    return peoplesPage;
  }
}