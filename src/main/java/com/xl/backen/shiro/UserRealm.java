package com.xl.backen.shiro;

import com.xl.backen.dao.PowersMapper;
import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Powers;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;

import java.util.*;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 后台管理员端的登录校验和权限控制
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UsersMapper us;

	@Autowired
	private PowersMapper pm;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权方法");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Users us = (Users) SecurityUtils.getSubject().getPrincipal();

		if (us != null) {
			Set<String> permis = new HashSet<String>();

			Map<String,String> map = new HashMap<>();
			map.put("roleId", us.getRoleId());
			map.put("type", us.getLoginType()+"");

			List<Powers> powers = pm.queryByRoleId(map);

			for (Powers p : powers) {
				System.out.println("追加code" + p.getCode());
				permis.add(p.getCode());
			}

			info.addStringPermissions(permis);
		}

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		CustomizedToken token = (CustomizedToken) authenticationToken;

		if (token.getLoginType() == CommonConst.LOGIN_TYPE_PC) {
			System.out.println("PC总后台登录");

			Map<String, String> map = new HashedMap<>();

			map.put("mobile", token.getUserName());
			map.put("communityId", "");

			Users usersModel = (Users) us.findByMobile(map);
			usersModel.setLoginType(CommonConst.LOGIN_TYPE_PC);
			return new SimpleAuthenticationInfo(usersModel, usersModel.getPassword(), this.getName());
		} else if (token.getLoginType() == CommonConst.LOGIN_TYPE_COMMUNITY) {
			System.out.println("社区pc登录");

			Map<String, String> map = new HashedMap<>();
			map.put("mobile", token.getUserName());
			map.put("communityId", "1");

			Users usersModel = (Users) us.findByMobile(map);
			usersModel.setLoginType(CommonConst.LOGIN_TYPE_COMMUNITY);
			return new SimpleAuthenticationInfo(usersModel, usersModel.getPassword(), this.getName());
		} else {
			return null;
		}
	}
}