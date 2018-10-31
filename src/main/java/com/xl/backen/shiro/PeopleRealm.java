package com.xl.backen.shiro;

import java.util.*;

import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.dao.WxUsersMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.entity.WxUsers;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.util.StringUtil;
import org.apache.commons.collections4.map.HashedMap;
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
            String appId = tokenPeoples.getAppId();
            String userName = tokenPeoples.getMobile();
            String password = tokenPeoples.getPassword();

            Peoples peoples = pm.queryByOpenId(openId, appId, userName, password);

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
                    u.setAppId(tokenPeoples.getAppId());
                    wum.insertSelective(u);
                    Peoples p = packAgePeoples(u);
                    // 社区id
                    p.setCommunityId(tokenPeoples.getCommunityId());
                    return new SimpleAuthenticationInfo(p, StringUtil.isEmpty(count.getAppId()) ? count.getOpenId() : count.getAppId(), this.getName());
                } else {
                    Peoples p = packAgePeoples(count);
                    // 社区id
                    p.setCommunityId(tokenPeoples.getCommunityId());
                    return new SimpleAuthenticationInfo(p, StringUtil.isEmpty(count.getAppId()) ? count.getOpenId() : count.getAppId(), this.getName());
                }
            } else {
                //有数据直接登录
                peoples.setCommunityId(tokenPeoples.getCommunityId());
                return new SimpleAuthenticationInfo(peoples, StringUtil.isEmpty(peoples.getAppId()) ? peoples.getOpenId() : peoples.getAppId(), this.getName());
            }
        }

        if (token.getLoginType() == CommonConst.LOGIN_TYPE_WX) {
            System.out.println("wx login");
            Peoples usersModel = (Peoples) pm.findByMobile(token.getUserName());
            return new SimpleAuthenticationInfo(usersModel, usersModel.getPassword(), this.getName());
        }

        if (token.getLoginType() == CommonConst.LOGIN_GZH) {
            System.out.println("公众号登陆");
            Peoples tokenPeoples = token.getPeoples();
            System.out.println("tokenPeoples:----" + tokenPeoples.toString());
            String openId = tokenPeoples.getOpenId();
            String appId = tokenPeoples.getAppId();
            Peoples peoples = pm.queryByOpenId(openId, appId, "", "");
            if (peoples == null) {
                //没有信息
                String uuid = UUID.randomUUID().toString().replace("-", "");
                tokenPeoples.setUuid(uuid);
                tokenPeoples.setCreateTime(new Date());
                tokenPeoples.setUpdateTime(new Date());
                tokenPeoples.setIsRealName(CommonConst.NO_REAL_NAME);
                tokenPeoples.setStatus(CommonConst.NORMAL_STATUS);
                tokenPeoples.setRole(CommonConst.NOMARL_USER);

                pm.insertSelective(tokenPeoples);

                return new SimpleAuthenticationInfo(tokenPeoples, StringUtil.isEmpty(tokenPeoples.getAppId()) ? tokenPeoples.getOpenId() : tokenPeoples.getAppId(), this.getName());
            } else {
                System.out.println("openId:" + peoples.getOpenId());
                System.out.println("appId: " + peoples.getAppId());
                return new SimpleAuthenticationInfo(peoples, StringUtil.isEmpty(peoples.getAppId()) ? peoples.getOpenId() : peoples.getAppId(), this.getName());
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
        p.setAppId(users.getAppId());
        return p;
    }
}
