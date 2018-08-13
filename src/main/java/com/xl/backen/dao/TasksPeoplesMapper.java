package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.entity.TasksPeoples;
import com.xl.backen.model.TasksPeopleModel;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TasksPeoplesMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(TasksPeoples record);

    int insertSelective(TasksPeoples record);

    TasksPeoples selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(TasksPeoples record);

    int updateByPrimaryKey(TasksPeoples record);

    /**
     * 查询“我的任务”
     * @return
     */
    Page<Tasks> findByPeople(TasksPeopleModel tp);

    /**
     * 查询任务下面的报名人
     */
    Page<Peoples> findByTasksId(TasksPeopleModel tp);

    /**
     * 根据people_id和tasks_id count
     */
    int exist(Map<String,String> map);
}