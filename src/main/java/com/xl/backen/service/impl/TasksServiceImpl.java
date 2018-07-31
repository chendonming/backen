package com.xl.backen.service.impl;

import java.util.Date;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.TasksMapper;
import com.xl.backen.entity.Tasks;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.TasksPageModel;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.TasksService;
import com.xl.backen.util.TimeUtil;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TasksServiceImpl
 */
@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    private TasksMapper tm;

    @Override
    @Transactional
    public int add(Tasks tasks) {
        tasks.setUuid(UUID.randomUUID().toString().replace("-", ""));

        UsersModel usersModel = (UsersModel) SecurityUtils.getSubject().getPrincipal();
        String uuid = usersModel.getUuid();
        tasks.setCreateUser(uuid);

        Date sDate = tasks.getStartTime();
        Date eDate = tasks.getEndTime();
        TimeUtil.volidTime(sDate, eDate);
        tasks.setStatus(CommonConst.NORMAL_STATUS);
        return tm.insertSelective(tasks);
    }

    @Override
    public Page<Tasks> query(TasksPageModel model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<Tasks> tasks = tm.query(model);
        return tasks;
    }

    /**
     * 更新操作
     */
    @Override
    public int update(Tasks tasks) {
        return tm.updateByPrimaryKeySelective(tasks);
    }

}