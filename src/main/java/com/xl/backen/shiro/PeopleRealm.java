package com.xl.backen.shiro;

import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.service.PeoplesService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 小程序端的登录校验
 */
public class PeopleRealm extends AuthorizingRealm {

	@Autowired
	private PeoplesMapper pm;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		Peoples peoples = (Peoples) pm.findByMobile(token.getUsername());

		System.out.println("peoples: " + peoples);

		if (peoples == null) {
			return null;
		} else {
			return new SimpleAuthenticationInfo(peoples,peoples.getPassword(),this.getName());
		}
	}
}
