package com.xl.backen.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.PeoplesIntegralIntMapper;
import com.xl.backen.dao.TasksMapper;
import com.xl.backen.dao.TasksPeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.entity.TasksPeoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.model.AppTasksModel;
import com.xl.backen.model.TasksPageModel;
import com.xl.backen.model.TasksPeopleModel;
import com.xl.backen.service.AppTasksService;
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
public class AppTasksServiceImpl implements AppTasksService {

	@Autowired
	private TasksMapper tm;

	@Autowired
	private TasksPeoplesMapper tpm;

	@Autowired
	private PeoplesIntegralIntMapper pil;

	@Override
	public Page<Tasks> query(TasksPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());

		Page<Tasks> tasks = tm.query(model);
		for (Tasks i : tasks) {
			i.setFlag(TimeUtil.compareTime(i.getStartTime(), i.getEndTime()));

			if(!StringUtil.isEmpty(i.getCoverpic())) {
				List<String> stringList = (List<String>) JSON.parse(i.getCoverpic());

				i.setCoverpicList(stringList);
			}
		}
		return tasks;
	}

	@Override
	@Transactional
	public int joinTask(String taskId) {
		if (StringUtil.isEmpty(taskId)) {
			throw new BusinessException(BusinessStatus.UUID_REQ);
		}

		TasksPeoples tp = new TasksPeoples();
		tp.setCreateTime(new Date());
		tp.setUpdateTime(new Date());
		tp.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
		tp.setTaskId(taskId);
		tp.setUuid(UUID.randomUUID().toString().replace("-", ""));

		int count = tpm.insertSelective(tp);

		if (count <= 0) {
			throw new BusinessException(BusinessStatus.INSERT_ERROR);
		}

		// 根据任务id进行修改
		synchronized (new Object()) {
			Tasks task = tm.selectByPrimaryKey(taskId);
			int joinPeople = task.getJoinPeople() == null ? 0 : task.getJoinPeople();

			task.setJoinPeople(joinPeople + 1);

			count = tm.updateByPrimaryKeySelective(task);

			if (count <= 0) {
				throw new BusinessException(BusinessStatus.UPDATE_ERROR);
			}
		}

		return 1;
	}

	@Override
	public Page<Tasks> findByPeople(TasksPeopleModel tp) {
		if (tp.getPageNum() != null && tp.getPageSize() != null) {
			PageHelper.startPage(tp.getPageNum(), tp.getPageSize());
		}

		tp.setPeopleId(((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());

		Page<Tasks> t = tpm.findByPeople(tp);


		List<Tasks> tasks = t.getResult();

		for (Tasks i : tasks) {
			int f = TimeUtil.compareTime(i.getStartTime(), i.getEndTime());
			i.setFlag(f);

			if(!StringUtil.isEmpty(i.getCoverpic())) {
				List<String> stringList = (List<String>) JSON.parse(i.getCoverpic());

				i.setCoverpicList(stringList);
			}
		}

		Page<Tasks> tasksPage = (Page<Tasks>) tasks;

		return tasksPage;
	}

	/**
	 * 通过peopleid查询报名任务
	 * @param
	 * @return
	 */
	@Override
	public Page<Tasks> findByPeopleId(TasksPeopleModel tp) {
		if (tp.getPageNum() != null && tp.getPageSize() != null) {
			PageHelper.startPage(tp.getPageNum(), tp.getPageSize());
		}

		Page<Tasks> t = tpm.findByPeople(tp);
		/*peopleid拥有的已兑换的任务列表*/
		List<Tasks> tasksList = pil.queryByPeopleId(tp.getPeopleId());
		/*peopleid拥有的任务*/
		List<Tasks> tasks = t.getResult();

		/*任务已兑换*/
		List<Tasks> tasksSame = ArrayUtil.compareArrSame(tasks,tasksList);

		for (Tasks i : tasks) {
			int f = TimeUtil.compareTime(i.getStartTime(), i.getEndTime());
			i.setFlag(f);

			if(!StringUtil.isEmpty(i.getCoverpic())) {
				List<String> stringList = (List<String>) JSON.parse(i.getCoverpic());

				i.setCoverpicList(stringList);
			}

			//告诉前端tasks是否已兑换
			for(Tasks j: tasksSame) {
				if(i == j) {
					/*已兑换*/
					i.setDistribute(true);
				}
			}
		}

		Page<Tasks> tasksPage = (Page<Tasks>) tasks;

		return tasksPage;
	}

	/**
	 * 查询任务下面的报名人
	 * 
	 * @param tp
	 * @return
	 */
	@Override
	public Page<Peoples> findByTasksId(TasksPeopleModel tp) {
		if (tp.getPageNum() != null && tp.getPageSize() != null) {
			PageHelper.startPage(tp.getPageNum(), tp.getPageSize());
		}

		tp.setTaskId(tp.getTaskId());

		return tpm.findByTasksId(tp);
	}

	@Override
	public AppTasksModel findOne(String taskId) {

		AppTasksModel tasks = tm.findOne(taskId);

		Map<String, String> map = new HashMap<>();
		map.put("peopleId", ((Peoples) SecurityUtils.getSubject().getPrincipal()).getUuid());
		map.put("taskId", taskId);

		int i = tpm.exist(map);
		if (i > 0) {
			tasks.setIs_join_task(true);
		} else {
			tasks.setIs_join_task(false);
		}

		int f = TimeUtil.compareTime(tasks.getStartTime(), tasks.getEndTime());
		tasks.setFlag(f);

		if(!StringUtil.isEmpty(tasks.getCoverpic())) {
			List<String> stringList = (List<String>) JSON.parse(tasks.getCoverpic());

			tasks.setCoverpicList(stringList);
		}

		return tasks;
	}

}
