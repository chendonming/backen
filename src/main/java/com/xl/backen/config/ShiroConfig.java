package com.xl.backen.config;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xl.backen.filter.LoginVolidFilter;
import com.xl.backen.filter.PermissionsVolidFilter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

@Configuration
public class ShiroConfig {

	@Value("${permission.menusModel}")
	private String menus;

	@Value("${permission.operation}")
	private String operation;

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		filters.put("authc", new LoginVolidFilter());
		filters.put("perms", new PermissionsVolidFilter());
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

		Map<String, String> map = new LinkedHashMap<String, String>();

		String[] t = menus.split(",");
		String[] t1 = operation.split(",");

		map.put("/user/login", "anon");
		map.put("/**", "authc");
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t1.length; j++) {
				map.put("/" + t[i] + "/" + t1[j], "perms[" + t[i] + ":" + t1[j] + "]");
			}
		}
		map.put("/permiss/**/**", "perms[permiss]");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

		return shiroFilterFactoryBean;
	}

	@Bean(name = "defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(
		@Qualifier("userRealm") UserRealm userRealm
	) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联realm
//		List<Realm> realmList = new ArrayList<>();
//		realmList.add(new UserRealm());
//		realmList.add(new PeopleRealm());
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	@Bean(name="userRealm")
	public UserRealm userRealm() {
		return new UserRealm();
	}

	@Bean
	public PeopleRealm peopleRealm() {
		return new PeopleRealm();
	}

	/**
	 * 系统自带的Realm管理，主要针对多realm
	 *
	 * FirstSuccessfulStrategy 只要有一个生效就不会进行其他验证
	 *
	 * AtLeastOneSuccessfulStrategy  至少有一个生效
	 *
	 * AllSuccessfulStrategy 所有的realm生效才能登录
	 */
//	@Bean
//	public ModularRealmAuthenticator modularRealmAuthenticator() {
//		ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
//		modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//		return modularRealmAuthenticator;
//	}

}
