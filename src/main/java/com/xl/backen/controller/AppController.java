package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.model.ActivitysPageModel;
import com.xl.backen.model.ActivitysPeopleModel;
import com.xl.backen.model.AppActivitysModel;
import com.xl.backen.model.AppTasksModel;
import com.xl.backen.model.TasksPageModel;
import com.xl.backen.model.TasksPeopleModel;
import com.xl.backen.service.AppActivitysService;
import com.xl.backen.service.AppTasksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app")
public class AppController {
	private static Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private AppActivitysService ts;

	@Autowired
	private AppTasksService at;

	@RequestMapping(value = "/queryAct", method = RequestMethod.POST)
	public ResultForPage<Activitys> queryAct(@RequestBody @Valid ActivitysPageModel model) {
		log.info("活动分页条件查询，参数model={}", model);
		Page<Activitys> tasks = ts.query(model);

		PageInfo<Activitys> info = new PageInfo<>(tasks);

		return new ResultForPage<Activitys>(BusinessStatus.SUCCESS, info);
	}

	@RequestMapping(value = "/queryTasks", method = RequestMethod.POST)
	public ResultForPage<Tasks> queryTasks(@RequestBody @Valid TasksPageModel model) {
		log.info("任务分页条件查询，参数model={}", model);
		Page<Tasks> tasks = at.query(model);

		PageInfo<Tasks> info = new PageInfo<>(tasks);

		return new ResultForPage<Tasks>(BusinessStatus.SUCCESS, info);
	}

	@RequestMapping(value = "/queryOneTasks", method = RequestMethod.POST)
	public Result<AppTasksModel> queryOneTasks(@RequestBody @Valid TasksPageModel model) {
		log.info("任务分页单个查询，参数model={}", model);

		return new Result<AppTasksModel>(BusinessStatus.SUCCESS, at.findOne(model.getUuid()));
	}

	@RequestMapping(value = "/queryOneActs", method = RequestMethod.POST)
	public Result<AppActivitysModel> queryOneActs(@RequestBody @Valid ActivitysPageModel model) {
		log.info("任务分页单个查询，参数model={}", model);
		return new Result<AppActivitysModel>(BusinessStatus.SUCCESS, ts.findOne(model.getUuid()));
	}

	@RequestMapping(value = "/joinAct", method = RequestMethod.GET)
	public Result<Object> joinAct(@RequestParam("actId") String actId) {
		log.info("参加活动,活动id={}", actId);
		ts.joinAct(actId);
		return new Result<Object>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/joinTask", method = RequestMethod.GET)
	public Result<Object> joinTask(@RequestParam("taskId") String taskId) {
		log.info("参加任务,任务id={}", taskId);
		at.joinTask(taskId);
		return new Result<Object>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/queryMyTasks", method = RequestMethod.POST)
	public ResultForPage<Tasks> queryMyTasks(@RequestBody TasksPeopleModel tp) {
		log.info("查询我的任务参数: {}", tp);
		Page<Tasks> tasks = at.findByPeople(tp);
		PageInfo<Tasks> tasksPageInfo = new PageInfo<>(tasks);
		return new ResultForPage<Tasks>(BusinessStatus.SUCCESS, tasksPageInfo);
	}

	@RequestMapping(value = "/queryMyAct", method = RequestMethod.POST)
	public ResultForPage<Activitys> queryMyAct(@RequestBody ActivitysPeopleModel ap) {
		log.info("查询我的活动，参数={}", ap);
		Page<Activitys> activitys = ts.findByPeople(ap);
		PageInfo<Activitys> activitysPageInfo = new PageInfo<>(activitys);
		return new ResultForPage<Activitys>(BusinessStatus.SUCCESS, activitysPageInfo);
	}

	@RequestMapping(value = "/queryActByPeople", method = RequestMethod.GET)
	public ResultForPage<Activitys> queryActByPeople(@RequestParam("uuid") String uuid,
													 @RequestParam("pageNum") Integer pageNum,
													 @RequestParam("pageSize") Integer pageSize) {
		log.info("根据用户id查询活动，参数={}", uuid);

		ActivitysPeopleModel ap = new ActivitysPeopleModel();
		ap.setPeopleId(uuid);
		ap.setPageNum(pageNum);
		ap.setPageSize(pageSize);

		Page<Activitys> activitys = ts.findByPeopleId(ap);
		PageInfo<Activitys> activitysPageInfo = new PageInfo<>(activitys);
		return new ResultForPage<Activitys>(BusinessStatus.SUCCESS, activitysPageInfo);
	}

	@RequestMapping(value = "/queryTaskByPeople", method = RequestMethod.GET)
	public ResultForPage<Tasks> queryTaskByPeople(@RequestParam("uuid") String uuid,
												  @RequestParam("pageNum") Integer pageNum,
												  @RequestParam("pageSize") Integer pageSize) {
		log.info("根据用户id查询任务，参数={}", uuid);

		TasksPeopleModel tp = new TasksPeopleModel();
		tp.setPeopleId(uuid);
		tp.setPageNum(pageNum);
		tp.setPageSize(pageSize);

		Page<Tasks> tasks = at.findByPeopleId(tp);
		PageInfo<Tasks> tasksPageInfo = new PageInfo<>(tasks);
		return new ResultForPage<Tasks>(BusinessStatus.SUCCESS, tasksPageInfo);
	}

	/**
	 * 查询任务报名的人
	 * 
	 * @param tp
	 * @return
	 */
	@RequestMapping(value = "/queryTaskPeople", method = RequestMethod.POST)
	public ResultForPage<Peoples> queryTaskPeople(@RequestBody TasksPeopleModel tp) {
		log.info("查询任务报名：{}",tp);
		Page<Peoples> activitys = at.findByTasksId(tp);
		PageInfo<Peoples> activitysPageInfo = new PageInfo<>(activitys);
		return new ResultForPage<Peoples>(BusinessStatus.SUCCESS, activitysPageInfo);
	}

	/**
	 * 查询活动报名的人
	 * 
	 * @param tp
	 * @return
	 */
	@RequestMapping(value = "/queryActPeople", method = RequestMethod.POST)
	public ResultForPage<Peoples> queryActPeople(@RequestBody ActivitysPeopleModel ap) {
		log.info("查询活动报名：{}",ap);
		Page<Peoples> activitys = ts.findByActId(ap);
		PageInfo<Peoples> activitysPageInfo = new PageInfo<>(activitys);
		return new ResultForPage<Peoples>(BusinessStatus.SUCCESS, activitysPageInfo);
	}
}
