package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.ActivitysPageModel;

import java.util.List;

/**
 * ActivitysService
 */
public interface ActivitysService {
  int add(Activitys activitys);

  Page<Activitys> query(ActivitysPageModel model);

  int update(Activitys tasks);

  Activitys findById(String uuid);

  // 查询参加活动的具体人数
  Page<Peoples> findJoinPeoples(String uuid, Integer pageSize, Integer pageNum);
}