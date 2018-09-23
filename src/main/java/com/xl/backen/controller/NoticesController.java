/**
 * 
 */
package com.xl.backen.controller;

import javax.validation.Valid;

import com.github.pagehelper.Page;
import com.xl.backen.handler.PageInfo;
import net.sf.ehcache.search.expression.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xl.backen.entity.Notices;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.NoticesService;

import java.util.Map;

/**
 * @author chendm
 */
@RestController
@RequestMapping("/notices")
public class NoticesController {
	private static Logger log = LoggerFactory.getLogger(NoticesController.class);

	@Autowired
	private NoticesService ns;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Object> add(@RequestBody @Valid Notices notices) {
		log.info("公告新增，参数notices={}", notices);
		ns.add(notices);
		return new Result<>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Object> update(@RequestBody @Valid Notices notices) {
		log.info("公告修改，参数notices={}", notices);
		ns.update(notices);
		return new Result<>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Result<Object> del(@RequestBody @Valid Notices notices) {
		log.info("公告删除，参数notices={}", notices);
		ns.del(notices);
		return new Result<>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Result<Object> query(@RequestBody @Valid Map<String, Object> map) {
		log.info("公告查询，参数notices={}", map);
		Page<Notices> noticesPage = ns.query(map);
		PageInfo<Notices> noticesPageInfo = new PageInfo<>(noticesPage);
		return new Result<>(BusinessStatus.SUCCESS, noticesPageInfo);
	}

	@RequestMapping(value = "/queryOne", method = RequestMethod.POST)
	public Result<Notices> queryOne(@RequestBody @Valid Map<String, Object> map) {
		Notices notices = ns.queryOne((String) map.get("uuid"));
		return new Result<>(BusinessStatus.SUCCESS, notices);
	}
}
