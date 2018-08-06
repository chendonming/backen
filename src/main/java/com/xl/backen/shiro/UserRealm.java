package com.xl.backen.shiro;

import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Menus;
import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Powers;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.UsersModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 后台管理员端的登录校验和权限控制
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UsersMapper us;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		UsersModel us = (UsersModel) SecurityUtils.getSubject().getPrincipal();

		if (us != null) {
			Set<String> permis = new HashSet<String>();

			List<ParentMenus> pms = us.getParentMenus();

			for (ParentMenus pm : pms) {
				for (Powers j : pm.getPowers()) {
					if (!StringUtils.isEmpty(j.getUuid())) {
						permis.add(j.getCode());
					}
				}
			}
			info.addStringPermissions(permis);
		}

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		CustomizedToken token = (CustomizedToken)authenticationToken;

		if(token.getLoginType() == CommonConst.LOGIN_TYPE_PC) {
			System.out.println("PC登录");
			Users usersModel = (Users) us.findByMobile(token.getUserName());
			if (usersModel == null) {
				return null;
			}else {
				return new SimpleAuthenticationInfo(usersModel, usersModel.getPassword(), this.getName());
			}
		}else {
			return null;
		}
	}


	/**
	 * 清理权限缓存
	 */
	public void clearCachedAuthorization() {
		//清空权限缓存
		clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}
}