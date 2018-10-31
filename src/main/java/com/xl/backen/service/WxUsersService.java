package com.xl.backen.service;

import com.xl.backen.entity.Peoples;

/**
 * 微信用户服务
 */
public interface WxUsersService {
    /**
     * APP端登录
     *
     * @param
     * @return
     */
    Peoples login(Peoples peoples);

    /**
     * 微信公众号登陆
     *
     * @param appid        APPID
     * @param REDIRECT_URI 回调地址
     * @return
     */
    Peoples gzhLogin(String openid, String appid, Peoples peoples);

    /**
     * APP端实名认证
     */
    int authentication(Peoples peoples);

    /**
     * 微信密码登陆
     *
     * @param peoples
     * @return
     */
    Peoples wxlogin(String username, String password, Integer loginType);
}
