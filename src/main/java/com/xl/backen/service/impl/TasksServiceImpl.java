package com.xl.backen.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.TasksMapper;
import com.xl.backen.dao.TasksPeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.entity.TasksPeoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.TasksPageModel;
import com.xl.backen.model.TasksPeopleModel;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.TasksService;
import com.xl.backen.util.StringUtil;
import com.xl.backen.util.TimeUtil;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.windows.ThemeReader;

/**
 * TasksServiceImpl
 */
@Service
public class TasksServiceImpl implements TasksService {
    private static Logger log = LoggerFactory.getLogger(TasksServiceImpl.class);

    @Autowired
    private TasksMapper tm;

    @Autowired
    private TasksPeoplesMapper tpm;

    @Override
    @Transactional
    public int add(Tasks tasks) {
        log.info("新增任务task = {}", tasks);

        tasks.setUuid(UUID.randomUUID().toString().replace("-", ""));

        Users usersModel = (Users) SecurityUtils.getSubject().getPrincipal();
        String uuid = usersModel.getUuid();
        tasks.setCreateUser(uuid);

        Date sDate = tasks.getStartTime();
        Date eDate = tasks.getEndTime();
        TimeUtil.volidTime(sDate, eDate);
        tasks.setStatus(CommonConst.NORMAL_STATUS);

        tasks.setCreateTime(new Date());
        tasks.setUpdateTime(new Date());
        return tm.insertSelective(tasks);
    }

    @Override
    public Page<Tasks> query(TasksPageModel model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize());

        Users usersModel = (Users) SecurityUtils.getSubject().getPrincipal();
        model.setCommunityId(usersModel.getCommunityId());
        model.setSysType(usersModel.getSysType());

        Page<Tasks> tasks = tm.query(model);
        for (Tasks i : tasks) {
            i.setFlag(TimeUtil.compareTime(i.getStartTime(), i.getEndTime()));
        }
        return tasks;
    }

    /**
     * 更新操作
     */
    @Override
    public int update(Tasks tasks) {
        return tm.updateByPrimaryKeySelective(tasks);
    }

    @Override
    public Tasks findById(String uuid) {
        Tasks tasks = tm.selectByPrimaryKey(uuid);

        int b = TimeUtil.compareTime(tasks.getStartTime(),tasks.getEndTime());
        tasks.setFlag(b);

        return tasks;
    }
}