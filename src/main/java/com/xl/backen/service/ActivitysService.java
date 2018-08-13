package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.model.ActivitysPeopleModel;

/**
 * ActivitysService
 */
public interface ActivitysService {
  int add(Activitys activitys);

  Page<Activitys> query(ActivitysPageModel model);

  int update(Activitys tasks);

  Activitys findById(String uuid);
}