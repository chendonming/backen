package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Communitys;
import com.xl.backen.handler.*;
import com.xl.backen.model.CommunitysForAddModel;
import com.xl.backen.model.CommunitysPageModel;
import com.xl.backen.service.CommunitysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunitysController {
	private static Logger log = LoggerFactory.getLogger(CommunitysController.class);

	@Autowired
	private CommunitysService cs;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Object> add(@RequestBody CommunitysForAddModel communitysForAddModel) throws Exception {
		log.info("新增社区接口，参数: {}",communitysForAddModel);
		cs.add(communitysForAddModel);
		return new Result<>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResultForPage<Communitys> query(@RequestBody CommunitysPageModel model) {
		log.info("分页条件查询社区接口，参数: {}",model);
		Page<Communitys> page = cs.query(model);
		PageInfo<Communitys> pageInfo = new PageInfo<>(page);

		return new ResultForPage<Communitys>(BusinessStatus.SUCCESS, pageInfo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultForPage<Object> update(@RequestBody Communitys communitys) {
		log.info("修改社区接口，参数: {}",communitys);
		if(communitys.getStatus() != null) {
			throw new BusinessException(BusinessStatus.DEL_OPEAR_ERROR);
		}
		cs.update(communitys);
		return new ResultForPage<>(BusinessStatus.SUCCESS);
	}

	@RequestMapping(value = "/queryOne", method = RequestMethod.GET)
	public Result<Communitys> queryOne(@RequestParam("uuid") String uuid) {
		log.info("查询社区单个接口,参数uuid={}",uuid);
		Communitys communitys = cs.findById(uuid);
		return new Result<Communitys>(BusinessStatus.SUCCESS,communitys);
	}

}
