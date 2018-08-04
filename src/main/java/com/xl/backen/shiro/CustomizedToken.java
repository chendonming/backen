package com.xl.backen.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自己的token
 */
public class CustomizedToken extends UsernamePasswordToken {
    /**
     * 登录类型
     * @see com.xl.backen.handler.CommonConst
     */
    private String LoginType;

    public CustomizedToken(String username, char[] password, String loginType) {
        super(username, password);
        LoginType = loginType;
    }

    public String getLoginType() {
        return LoginType;
    }

    public void setLoginType(String loginType) {
        LoginType = loginType;
    }
}
