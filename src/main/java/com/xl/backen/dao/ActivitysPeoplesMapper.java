package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.ActivitysPeoples;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.ActivitysPeopleModel;

import com.xl.backen.model.TasksPeopleModel;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ActivitysPeoplesMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ActivitysPeoples record);

    int insertSelective(ActivitysPeoples record);

    ActivitysPeoples selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ActivitysPeoples record);

    int updateByPrimaryKey(ActivitysPeoples record);

    /**
     * 查询我的活动
     */
    Page<Activitys> findByPeople(ActivitysPeopleModel ap);

    /**
     * 查询活动下面的报名人
     */
    Page<Peoples> findByActId(ActivitysPeopleModel ap);

    /**
     * 根据people_id和tasks_id count
     */
    int exist(Map map);
}