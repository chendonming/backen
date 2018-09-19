package com.xl.backen.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.UsersPageModel;
import com.xl.backen.model.UsersRegisterRoleModel;
import com.xl.backen.service.UsersService;
import com.xl.backen.shiro.CustomizedToken;
import com.xl.backen.util.MD5;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
@CacheConfig(cacheNames = "permiss")
public class UsersServiceImpl implements UsersService {

	@Value("${server.session.timeout}")
	private Long sessionTimeOut;

	@Autowired
	private UsersMapper usersMapper;

	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public Users findByMobile(Map<String,String> map) {
		return usersMapper.findByMobile(map);
	}

	@Override
	public Users login(String username, String password, Integer loginType) {
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
			token.setLoginType(loginType);
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
	@CacheEvict(allEntries=true)
	public String Register(Users users) {
		if (StringUtils.isEmpty(users.getMobile())) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		}
		
		Map<String,String> map = new HashMap<>();
		map.put("mobile", users.getMobile());
		map.put("communityId", users.getCommunityId());
		
		Users us = usersMapper.findByMobile(map);
		if (us == null) {
			Users usersModel = (Users)SecurityUtils.getSubject().getPrincipal();
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
	@Cacheable(keyGenerator = "keyGenerator")
	public Page<Users> queryAll(UsersPageModel model) {
		PageHelper.startPage(model.getPageNum(), model.getPageSize());

		Users u = (Users)SecurityUtils.getSubject().getPrincipal();
		model.setCommunityId(u.getCommunityId());

		Page<Users> users = usersMapper.queryAll(model);
		return users;
	}

	@Override
	@CacheEvict(allEntries=true)
	public int update(UsersRegisterRoleModel model) {
		usersMapper.updateByPrimaryKeySelective(model.getUser());
		return 1;
	}

	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public Users findById(String uuid) {
		return usersMapper.selectByPrimaryKey(uuid);
	}
}
