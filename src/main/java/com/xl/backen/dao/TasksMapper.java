package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Tasks;

import com.xl.backen.model.AppTasksModel;
import com.xl.backen.model.TasksPageModel;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Tasks record);

    int insertSelective(Tasks record);

    Tasks selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Tasks record);

    int updateByPrimaryKey(Tasks record);

    Page<Tasks> query(Tasks tasks);

    /**
     * 查询单个任务 APP
     * @param taskId
     * @return
     */
    AppTasksModel findOne(String uuid);
}