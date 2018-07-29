package com.xl.backen.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import com.alibaba.fastjson.JSONObject;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;

public class PermissionsVolidFilter extends PermissionsAuthorizationFilter{
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSONObject.toJSON(new Result(BusinessStatus.POWER_ERROR)).toString());
        return false;
    }
}
