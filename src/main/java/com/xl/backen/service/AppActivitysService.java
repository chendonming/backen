package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.*;

public interface AppActivitysService {
    Page<Activitys> query(ActivitysPageModel model);


    /**
     * /**
     * * APP参加活动(获取当前登录人的信息)
     */
    int joinAct(String actId);

    /**
     * * 查询“我的活动”
     * * @return
     */
    Page<Activitys> findByPeople(ActivitysPeopleModel ap);

    /**
     * 查询任务下面的报名人
     */
    Page<Peoples> findByActId(ActivitysPeopleModel ap);

    /**
     * 查询单个活动
     * @param
     * @return
     */
    AppActivitysModel findOne(String actId);
}
