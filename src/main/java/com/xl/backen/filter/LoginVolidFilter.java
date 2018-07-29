package com.xl.backen.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.alibaba.fastjson.JSONObject;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;

/**
 * shiro 登录失败错误捕捉
 * @author 作者 : chendm
 * @version 创建时间：2018年7月28日 下午10:20:55
 */
public class LoginVolidFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("application/json");
		httpServletResponse.getWriter().write(JSONObject.toJSON(new Result(BusinessStatus.LOGIN_ERROR)).toString());
		return false;
	}
	
}
