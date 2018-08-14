package com.xl.backen.controller;

import java.util.List;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Roles;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.PowersService;
import com.xl.backen.service.UsersService;
import com.xl.backen.service.WxUsersService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * shiro不做任何拦截的控制器
 */

@RestController
@RequestMapping("/user")
public class UsersController {
	private static Logger log = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UsersService usersService;

	@Autowired
	private PowersService psr;

	@Autowired
	private WxUsersService uss;

	/**
	 * 管理员登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<Users> login(@RequestBody Users user) {
		String mobile = user.getMobile();
		String password = user.getPassword();
		log.info("登录方法: mobile={},password={}", mobile, password);
		Users usersModel = usersService.login(mobile, password, user.getLoginType());
		usersModel.setPassword("");
		return new Result<Users>(BusinessStatus.SUCCESS, usersModel);
	}

	/**
	 * 小程序登录接口
	 */
	@RequestMapping(value = "/loginApp", method = RequestMethod.POST)
	public Result<Peoples> loginApp(@RequestBody Peoples peoples) {
		return new Result<Peoples>(BusinessStatus.SUCCESS,uss.login(peoples));
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/signOut", method = RequestMethod.POST)
	public Result<Object> signOut() {
		SecurityUtils.getSubject().logout();
		return new Result<>(BusinessStatus.SUCCESS);
	}

	/**
	 * 所有的菜单
	 * @return
	 */
	@RequestMapping(value = "/menus/queryAll", method = RequestMethod.POST)
	public Result<List<ParentMenus>> menusAll(@RequestBody Roles role){
		return new Result<List<ParentMenus>>(BusinessStatus.SUCCESS, psr.queryParentMenusByRoleId(role.getUuid()));
	}
}
