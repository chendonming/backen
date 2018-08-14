package com.xl.backen.shiro;

import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.CommonConst;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自己的token
 */
public class CustomizedToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 3412468759582256508L;

	/**
     * 登录类型
     * @see com.xl.backen.handler.CommonConst
     */
    private Integer LoginType;

    /**
     * 微信用户
     * @see com.xl.backen.entity.WxUsers
     */
    private Peoples peoples;

    /**
     * 后台登录通过userName 和 password校验
     */
    private String userName;
    private String passWord;


    /**
     * 重写getPrincipal方法
     */
    @Override
    public Object getPrincipal() {
        if(LoginType == CommonConst.LOGIN_TYPE_PC || LoginType == CommonConst.COMMUNITY_TYPE) {
            return getUserName();
        }else{
            return getPeoples().getOpenId();
        }
    }

    /**
     * 重写getCredentials方法
     */
    @Override
    public Object getCredentials() {
        if(LoginType == CommonConst.LOGIN_TYPE_PC || LoginType == CommonConst.COMMUNITY_TYPE) {
            return getPassWord();
        }else{
            return getPeoples().getOpenId();
        }
    }

    public CustomizedToken() {
    }

    public CustomizedToken(String username, char[] password, int loginType) {
        super(username, password);
        LoginType = loginType;
    }

    public Peoples getPeoples() {
        return peoples;
    }

    public void setPeoples(Peoples peoples) {
        this.peoples = peoples;
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
}
