package com.xl.backen.service.impl;

import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.UsersService;
import com.xl.backen.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public Users findByMobile(String uuid) {
		return usersMapper.findByMobile(uuid);
	}

	@Override
	public UsersModel login(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password:  " + password);
		if (StringUtils.isEmpty(username)) {
			throw new BusinessException(BusinessStatus.USERNAME_REQ);
		}
		if (StringUtils.isEmpty(password)) {
			throw new BusinessException(BusinessStatus.PASSWORD_REQ);
		}

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = null;

		try {
			token = new UsernamePasswordToken(username, MD5.md5(password));
		} catch (Exception e) {
			throw new BusinessException(BusinessStatus.MD5_ERROR);
		}

		try {
			subject.login(token);
			UsersModel usersModel = (UsersModel) subject.getPrincipal();
			return usersModel;
		} catch (UnknownAccountException e) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		} catch (IncorrectCredentialsException e) {
			throw new BusinessException(BusinessStatus.PASSWORD_ERROR);
		}
	}

	@Override
	public int Register(Users users) {
		Users us = usersMapper.findByMobile(users.getMobile());

		return usersMapper.insertSelective(users);
	}
}
