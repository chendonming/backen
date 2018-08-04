package com.xl.backen.common;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

/**
 * 提取的公共登录接口
 */
public class LoginService {
	/**
	 * 登录session的超时时间
	 */
	@Value("${server.session.timeout}")
	private static Long sessionTimeOut;

	public static void Login(String username, String password) {
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
			subject.getSession().setTimeout(sessionTimeOut);
			System.out.println("超时时间为: " + sessionTimeOut);

		} catch (UnknownAccountException e) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		} catch (IncorrectCredentialsException e) {
			throw new BusinessException(BusinessStatus.PASSWORD_ERROR);
		}
	}
}
