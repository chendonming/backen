package com.xl.backen.config;

import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Menus;
import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Powers;
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
				List<Menus> ms = pm.getMenus();
				for (Menus i : ms) {
					if (!StringUtils.isEmpty(i.getUuid())) {
						for (Powers j : i.getPowers()) {
							if (!StringUtils.isEmpty(j.getUuid())) {
								permis.add(j.getCode());
							}
						}
					}
				}
			}
			info.addStringPermissions(permis);
		}

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		UsersModel usersModel = (UsersModel) us.findByMobile(token.getUsername());

		System.out.println("usersModel: " + usersModel);

		if (usersModel == null) {
			return null;
		} else {
			return new SimpleAuthenticationInfo(usersModel, usersModel.getPassword(), this.getName());
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