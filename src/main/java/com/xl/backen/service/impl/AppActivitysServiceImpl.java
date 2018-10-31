package com.xl.backen.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ActivitysMapper;
import com.xl.backen.dao.ActivitysPeoplesMapper;
import com.xl.backen.dao.PeoplesIntegralIntMapper;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.ActivitysPeoples;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.model.*;
import com.xl.backen.service.AppActivitysService;
import com.xl.backen.util.ArrayUtil;
import com.xl.backen.util.StringUtil;
import com.xl.backen.util.TimeUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AppActivitysServiceImpl implements AppActivitysService {
    @Autowired
    private ActivitysMapper as;

    @Autowired
    private ActivitysPeoplesMapper apm;

    @Autowired
    private PeoplesIntegralIntMapper pil;

    @Override
    public Page<Activitys> query(ActivitysPageModel model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize());

        Page<Activitys> activitys = as.query(model);
        for (Activitys i : activitys) {
            int flag = TimeUtil.compareTime(i.getJoinStartTime(), i.getJoinEndTime(), i.getStartTime(), i.getEndTime());
            i.setFlag(flag);

            if (!StringUtil.isEmpty(i.getCoverpic())) {
                List<String> stringList = (List<String>) JSON.parse(i.getCoverpic());

                i.setCoverpicList(stringList);
            }
        }
        return activitys;
    }

    @Override
    @Transactional
    public int joinAct(String actId) {
        if (StringUtil.isEmpty(actId)) {
            throw new BusinessException(BusinessStatus.UUID_REQ);
        }

        Map map = new HashMap();
        map.put("peopleId", ((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
        map.put("actId", actId);

        int exist = apm.exist(map);
        if (exist > 0) {
            throw new BusinessException(500, "你已经报名过此活动");
        }

        ActivitysPeoples ap = new ActivitysPeoples();
        ap.setCreateTime(new Date());
        ap.setUpdateTime(new Date());
        ap.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
        ap.setActivityId(actId);
        ap.setUuid(UUID.randomUUID().toString().replace("-", ""));

        int count = apm.insertSelective(ap);
        if (count <= 0) {
            throw new BusinessException(BusinessStatus.INSERT_ERROR);
        }

        // 根据任务id进行修改
        synchronized (ap) {
            Activitys act = as.selectByPrimaryKey(actId);

            int joinPeople = act.getJoinPeople() == null ? 0 : act.getJoinPeople();

            act.setJoinPeople(joinPeople + 1);

            count = as.updateByPrimaryKeySelective(act);

            if (count <= 0) {
                throw new BusinessException(BusinessStatus.UPDATE_ERROR);
            }
        }

        return 1;
    }

    @Override
    public Page<Activitys> findByPeople(ActivitysPeopleModel ap) {
        if (ap.getPageNum() != null && ap.getPageSize() != null) {
            PageHelper.startPage(ap.getPageNum(), ap.getPageSize());
        }

        ap.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());

        return apm.findByPeople(ap);
    }

    /**
     * 根据peopleid查询活动
     *
     * @param ap
     * @return
     */
    @Override
    public Page<Activitys> findByPeopleId(ActivitysPeopleModel ap) {
        if (ap.getPageNum() != null && ap.getPageSize() != null) {
            PageHelper.startPage(ap.getPageNum(), ap.getPageSize());
        }

        Page<Activitys> t = apm.findByPeople(ap);
        /*peopleid拥有的已兑换的任务列表*/
        List<Activitys> tasksList = pil.queryActByPeopleId(ap.getPeopleId());
        /*peopleid拥有的任务*/
        List<Activitys> tasks = t.getResult();

        /*任务已兑换*/
        List<Activitys> tasksSame = ArrayUtil.compareArrSame(tasks, tasksList);

        for (Activitys i : tasks) {
            int f = TimeUtil.compareTime(i.getStartTime(), i.getEndTime());
            i.setFlag(f);

            if (!StringUtil.isEmpty(i.getCoverpic())) {
                List<String> stringList = (List<String>) JSON.parse(i.getCoverpic());

                i.setCoverpicList(stringList);
            }

            //告诉前端tasks是否已兑换
            for (Activitys j : tasksSame) {
                if (i == j) {
                    /*已兑换*/
                    i.setDistribute(true);
                }
            }
        }

        Page<Activitys> tasksPage = (Page<Activitys>) tasks;
        return apm.findByPeople(ap);
    }

    @Override
    public Page<Peoples> findByActId(ActivitysPeopleModel ap) {
        if (ap.getPageNum() != null && ap.getPageSize() != null) {
            PageHelper.startPage(ap.getPageNum(), ap.getPageSize());
        }

        Page<Peoples> peoples = apm.findByActId(ap);

        /*根据活动id查询到的peoples List*/
        List<Peoples> peoplesList = peoples.getResult();

        /*根据活动查询到的已派发的people LIST*/
        List<Peoples> pilPeoples = pil.queryPeopleByAct(ap.getActivityId());

        for (Peoples p : peoplesList) {
            for (Peoples i : pilPeoples) {
                if (p.getUuid().equals(i.getUuid())) {
                    p.setDistribute(true);
                }
            }
        }

        Page<Peoples> peoplePage = (Page<Peoples>) peoplesList;

        return peoplePage;
    }

    @Override
    public AppActivitysModel findOne(String actId) {
        AppActivitysModel activitysModel = as.findOne(actId);

        Map<String, String> map = new HashMap<>();
        map.put("peopleId", ((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
        map.put("actId", actId);
        int i = apm.exist(map);

        if (i > 0) {
            activitysModel.setIs_join_act(true);
        } else {
            activitysModel.setIs_join_act(false);
        }

        int f = TimeUtil.compareTime(activitysModel.getJoinStartTime(), activitysModel.getJoinEndTime(),
                activitysModel.getStartTime(), activitysModel.getEndTime());

        activitysModel.setFlag(f);

        if (!StringUtil.isEmpty(activitysModel.getCoverpic())) {
            List<String> stringList = (List<String>) JSON.parse(activitysModel.getCoverpic());

            activitysModel.setCoverpicList(stringList);
        }

        return activitysModel;
    }
}
