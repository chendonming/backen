package com.xl.backen.controller;

import javax.validation.Valid;

import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
	private static Logger log = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody Users user) {
		String mobile = user.getMobile();
		String password = user.getPassword();
		log.info("登录方法: mobile={},password={}", mobile, password);
		UsersModel usersModel = usersService.login(mobile, password);
		usersModel.setPassword("");
		return new Result(BusinessStatus.SUCCESS, usersModel);
	}
}
