package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.dao.PowersMapper;
import com.xl.backen.entity.*;
import com.xl.backen.handler.*;
import com.xl.backen.model.CommunitysForAddModel;
import com.xl.backen.model.CommunitysPageModel;
import com.xl.backen.model.RolesPowerModel;
import com.xl.backen.service.CommunitysService;
import com.xl.backen.service.RolesPowerService;
import com.xl.backen.service.UsersRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunitysController {
	private static Logger log = LoggerFactory.getLogger(CommunitysController.class);

	@Autowired
	private CommunitysService cs;

  @Autowired
  private RolesPowerService rps;

  @Autowired
  private UsersRoleService urs;

  @Autowired
  private PowersMapper pm;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
  @Transactional
	public Result<Object> add(@RequestBody CommunitysForAddModel communitysForAddModel) throws Exception {
		log.info("新增社区接口，参数: {}",communitysForAddModel);
		Users users = cs.add(communitysForAddModel);

		// 为角色赋予全部的权限
    RolesPowerModel rp = new RolesPowerModel();
    rp.setRoleId(CommonConst.COMMUNITY_ROLE);
    List<Powers> powers = pm.queryAll(CommonConst.COMMUNITY_TYPE);
    List<String> powersString = new ArrayList<>();
    for(Powers p : powers) {
      powersString.add(p.getUuid());
    }
    rp.setPowers(powersString);
    rps.givePermiss(rp);

    // 为用户赋予角色
    UsersRole ur = new UsersRole();
    ur.setRoleId(CommonConst.COMMUNITY_ROLE);
    ur.setUserId(users.getUuid());
    urs.allocationRole(ur);

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
