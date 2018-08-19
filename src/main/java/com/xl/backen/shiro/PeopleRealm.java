package com.xl.backen.shiro;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.dao.WxUsersMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.WxUsers;
import com.xl.backen.handler.CommonConst;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 小程序端的登录校验
 */
public class PeopleRealm extends AuthorizingRealm {

	@Autowired
	private PeoplesMapper pm;

	@Autowired
	private WxUsersMapper wum;

	@Value("${permission.menusModel}")
	private String menus;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Object o = SecurityUtils.getSubject().getPrincipal();

		if (o instanceof Peoples) {
			System.out.println("APP授权管理");
			String[] t = menus.split(",");

			Set<String> permis = new HashSet<String>();

			for (String i : t) {
				permis.add(i);
			}

			info.addStringPermissions(permis);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		CustomizedToken token = (CustomizedToken) authenticationToken;

		if (token.getLoginType() == CommonConst.LOGIN_TYPE_APP) {
			System.out.println("APP登录");
			Peoples tokenPeoples = token.getPeoples();
			String openId = tokenPeoples.getOpenId();

			Peoples peoples = pm.queryByOpenId(openId);

			System.out.println(peoples);

			if (peoples == null) {
				//peoples为空。则继续查询微信用户表以前是否登录
				WxUsers count = wum.queryWxByOpenId(openId);
				if (count == null) {
					WxUsers u = new WxUsers();
					//以前也没有登录过 则添加数据
					String uuid = UUID.randomUUID().toString().replace("-", "");
					u.setIsRealName(CommonConst.NO_REAL_NAME);
					u.setNickName(tokenPeoples.getNickname());
					u.setUuid(uuid);
					u.setCreateTime(new Date());
					u.setUpdateTime(new Date());
					u.setOpenId(openId);
					u.setGender(tokenPeoples.getSex());
					u.setAvatarUrl(tokenPeoples.getHeadPic());
					wum.insertSelective(u);
					Peoples p = packAgePeoples(u);
					return new SimpleAuthenticationInfo(p, p.getOpenId(), this.getName());
				} else {
					Peoples p = packAgePeoples(count);
					return new SimpleAuthenticationInfo(p, p.getOpenId(), this.getName());
				}
			} else {
				//有数据直接登录
				return new SimpleAuthenticationInfo(peoples, peoples.getOpenId(), this.getName());
			}
		}
		return null;
	}

	/**
	 * 将wxusers打包成peoples
	 */
	private Peoples packAgePeoples(WxUsers users) {
		Peoples p = new Peoples();
		p.setUuid(users.getUuid());
		p.setNickname(users.getNickName());
		p.setHeadPic(users.getAvatarUrl());
		p.setIsRealName(CommonConst.NO_REAL_NAME);
		p.setSex(users.getGender());
		p.setOpenId(users.getOpenId());
		return p;
	}
}
