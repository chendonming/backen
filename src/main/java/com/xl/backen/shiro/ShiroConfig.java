package com.xl.backen.shiro;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xl.backen.filter.LoginVolidFilter;
import com.xl.backen.filter.PermissionsVolidFilter;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

@Configuration
public class ShiroConfig {

	@Value("${permission.menusModel}")
	private String menus;

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		filters.put("authc", new LoginVolidFilter());
		filters.put("perms", new PermissionsVolidFilter());
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

		Map<String, String> map = new LinkedHashMap<String, String>();

		String[] t = menus.split(",");

		map.put("/user/**", "anon");

		for (int i = 0; i < t.length; i++) {
			if(t[i].equals("permiss")) {
				map.put("/permiss/**/**", "authc,perms[permiss]");
			}else {
				map.put("/" + t[i] + "/**add**", "authc,perms[" + t[i] + "]");
				map.put("/" + t[i] + "/**update**", "authc,perms[" + t[i] + "]");
				map.put("/" + t[i] + "/**del**", "authc,perms[" + t[i] + "]");
				map.put("/" + t[i] + "/**thumb**", "authc,perms[" + t[i] + "]");
				map.put("/" + t[i] + "/**My**", "authc,perms[" + t[i] + "]");
				map.put("/" + t[i] + "/**join**", "authc,perms[" + t[i] + "]");
			}
		}

		map.put("/app/**", "anon");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}

	@Bean(name = "defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(
		@Qualifier("userRealm") UserRealm userRealm,
		@Qualifier("peopleRealm") PeopleRealm peopleRealm,
		@Qualifier("ehCacheManager") EhCacheManager ehCacheManager,
		@Qualifier("sessionManager") SessionManager sessionManager
	) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联realm
		List<Realm> realmList = new ArrayList<>();
		realmList.add(userRealm);
		realmList.add(peopleRealm);
		securityManager.setRealms(realmList);

		securityManager.setCacheManager(ehCacheManager);
		securityManager.setSessionManager(sessionManager);
		return securityManager;
	}

	@Bean(name = "userRealm")
	public UserRealm userRealm() {
		UserRealm ur = new UserRealm();
		return new UserRealm();
	}

	@Bean(name = "peopleRealm")
	public PeopleRealm peopleRealm() {
		return new PeopleRealm();
	}

	/**
	 * 系统自带的Realm管理，主要针对多realm
	 * <p>
	 * FirstSuccessfulStrategy 只要有一个生效就不会进行其他验证
	 * <p>
	 * AtLeastOneSuccessfulStrategy  至少有一个生效
	 * <p>
	 * AllSuccessfulStrategy 所有的realm生效才能登录
	 */
	@Bean(name="authenticator")
	public CustomizedModularRealmAuthenticator modularRealmAuthenticator() {
		CustomizedModularRealmAuthenticator modularRealmAuthenticator = new CustomizedModularRealmAuthenticator();
		modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		return modularRealmAuthenticator;
	}

	@Bean(name="ehCacheManager")
	public EhCacheManager ehCacheManager(){
		EhCacheManager ehCacheManager = new EhCacheManager();
		//配置Ehcache缓存配置文件,该缓存配置文件默认位置为“classpath:org/apache/shiro/cache/ehcache/ehcache.xml”
		//ehCacheManager.setCacheManagerConfigFile(FileLocation)
		return ehCacheManager;
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultHeaderSessionManager sm = new DefaultHeaderSessionManager();
		return sm;
	}

}
