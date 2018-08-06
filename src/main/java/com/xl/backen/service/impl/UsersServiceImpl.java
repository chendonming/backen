package com.xl.backen.service.impl;

import java.util.Date;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.UsersModel;
import com.xl.backen.model.UsersPageModel;
import com.xl.backen.model.UsersRegisterRoleModel;
import com.xl.backen.service.UsersService;
import com.xl.backen.shiro.CustomizedToken;
import com.xl.backen.util.MD5;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Value("${server.session.timeout}")
	private Long sessionTimeOut;

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public Users findByMobile(String uuid) {
		return usersMapper.findByMobile(uuid);
	}

	@Override
	public Users login(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password:  " + password);
		if (StringUtils.isEmpty(username)) {
			throw new BusinessException(BusinessStatus.USERNAME_REQ);
		}
		if (StringUtils.isEmpty(password)) {
			throw new BusinessException(BusinessStatus.PASSWORD_REQ);
		}

		Subject subject = SecurityUtils.getSubject();
		CustomizedToken token = null;

		try {
			token = new CustomizedToken();
			token.setUserName(username);
			token.setPassWord(MD5.md5(password));
			token.setLoginType(CommonConst.LOGIN_TYPE_PC);
		} catch (Exception e) {
			throw new BusinessException(BusinessStatus.MD5_ERROR);
		}

		try {
			subject.login(token);
			subject.getSession().setTimeout(sessionTimeOut);
			Users usersModel = (Users) subject.getPrincipal();
			return usersModel;
		} catch (UnknownAccountException e) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		} catch (IncorrectCredentialsException e) {
			throw new BusinessException(BusinessStatus.PASSWORD_ERROR);
		}
	}

	@Override
	@Transactional
	public String Register(Users users) {
		if (StringUtils.isEmpty(users.getMobile())) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		}
		Users us = usersMapper.findByMobile(users.getMobile());
		if (us == null) {
			UsersModel usersModel = (UsersModel)SecurityUtils.getSubject().getPrincipal();
			String uuid = UUID.randomUUID().toString().replace("-", "");
			users.setUuid(uuid);
			users.setCreateTime(new Date());
			users.setUpdateTime(new Date());
			users.setStatus(CommonConst.NORMAL_STATUS);
			users.setSysType(usersModel.getSysType());
			users.setCommunityId(usersModel.getCommunityId());

			if (StringUtil.isEmpty(users.getPassword())) {
				try {
					users.setPassword(MD5.md5("123456"));
				} catch (Exception e) {
					throw new BusinessException(BusinessStatus.MD5_ERROR);
				}
			}

			int i = usersMapper.insertSelective(users);
			if (i > 0) {
				return uuid;
			} else {
				throw new BusinessException(BusinessStatus.INSERT_ERROR);
			}
		} else {
			throw new BusinessException(BusinessStatus.MOBILE_ERROR);
		}
	}

	@Override
	public Page<Users> queryAll(UsersPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());

		UsersModel usersModel = (UsersModel)SecurityUtils.getSubject().getPrincipal();

		Page<Users> users = usersMapper.queryAll(model);
		return users;
	}

	@Override
	public int update(UsersRegisterRoleModel model) {
		usersMapper.updateByPrimaryKeySelective(model.getUser());
		return 1;
	}

	@Override
	public Users findById(String uuid) {
		return usersMapper.selectByPrimaryKey(uuid);
	}
}
