package com.xl.backen.shiro;

import com.xl.backen.handler.CommonConst;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自己的token
 */
public class CustomizedToken extends UsernamePasswordToken {
    /**
     * 登录类型
     * @see com.xl.backen.handler.CommonConst
     */
    private Integer LoginType;


    /**
     * 后台登录通过userName 和 password校验
     */
    private String userName;
    private String passWord;


    /**
     * APP通过open_id做校验
     */
    private String openId;
    private String appId;

    /**
     * 重写getPrincipal方法
     */
    @Override
    public Object getPrincipal() {
        // 如果获取到用户名，则返回用户名，否则返回电话号码
        if(LoginType == CommonConst.LOGIN_TYPE_PC) {
            return getUserName();
        }else{
            return openId;
        }
    }

    /**
     * 重写getCredentials方法
     */
    @Override
    public Object getCredentials() {
        // 如果获取到密码，则返回密码，否则返回null
        if(LoginType == CommonConst.LOGIN_TYPE_PC) {
            return getPassWord();
        }else{
            return appId;
        }
    }

    public CustomizedToken() {
    }

    public CustomizedToken(String openId, String appId, int loginType) {
        this.openId = openId;
        this.appId = appId;
        this.LoginType = loginType;
    }

    public CustomizedToken(String username, char[] password, int loginType) {
        super(username, password);
        LoginType = loginType;
    }

    public Integer getLoginType() {
        return LoginType;
    }

    public void setLoginType(Integer loginType) {
        LoginType = loginType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
