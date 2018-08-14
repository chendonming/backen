package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.model.VolunteerModel;

/**
 * VolunteerService
 */
public interface VolunteerService {
  int add(VolunteerModel volunteerModel);
  int update(VolunteerModel volunteerModel);
  VolunteerModel queryOne(String uuid);
  Page<VolunteerModel> queryList(VolunteerModel volunteerModel);
}