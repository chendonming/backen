package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.model.AppTasksModel;
import com.xl.backen.model.TasksPageModel;
import com.xl.backen.model.TasksPeopleModel;

public interface AppTasksService {
    Page<Tasks> query(TasksPageModel model);

    /**
     * APP参加任务(获取当前登录人的信息)
     */
    int joinTask(String taskId);

    /**
     * 查询“我的任务”
     * @return
     */
    Page<Tasks> findByPeople(TasksPeopleModel tp);

    /**
     * 根据用户id查询任务
     * @return
     */
    Page<Tasks> findByPeopleId(TasksPeopleModel tp);

    /**
     * 查询任务下面的报名人
     */
    Page<Peoples> findByTasksId(TasksPeopleModel tp);

    /**
     * 查询单个任务
     * @param taskId
     * @return
     */
    AppTasksModel findOne(String taskId);
}
