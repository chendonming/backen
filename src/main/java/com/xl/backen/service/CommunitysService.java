package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Communitys;
import com.xl.backen.entity.Users;
import com.xl.backen.model.CommunitysForAddModel;
import com.xl.backen.model.CommunitysPageModel;

public interface CommunitysService {
  Users add (CommunitysForAddModel communitys) throws Exception;

	int update(Communitys communitys);

	Page<Communitys> query(CommunitysPageModel model);

	Communitys findById(String uuid);
}
