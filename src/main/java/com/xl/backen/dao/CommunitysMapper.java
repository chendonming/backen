package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Communitys;
import com.xl.backen.model.CommunitysPageModel;

public interface CommunitysMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Communitys record);

    int insertSelective(Communitys record);

    Communitys selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Communitys record);

    int updateByPrimaryKey(Communitys record);

    Page<Communitys> query(CommunitysPageModel model);
}