package com.xl.backen.handler;

/**
 * 常量类
 */
public class CommonConst {
    public static final int NORMAL_STATUS = 1;
    
    public static final int DEL_STATUS = 2;

    //任务，活动
    public static final int NO_START = 1; //未开始

    public static final int IN_START = 2; //正在进行中

    public static final int OUT_START = 3; //已结束

    public static final int ACTIVITY_IN_START = 4; //活动已开始

    public static final int ACTIVITY_OUT_START = 5; //活动结束

    //居民
    public static final int IS_REAL_NAME = 1; //已经实名
    public static final int NO_REAL_NAME = 2; //未实名

    //APP登录身份
    public static final int NOMARL_USER = 1; //普通居民
    public static final int VOLUNTEER_USER = 2; //志愿者
    public static final int COMMUNITY_WORK_USER = 3; //社工

    //登录
    public static final int LOGIN_TYPE_PC = 1; //pc后台登录
    public static final int LOGIN_TYPE_COMMUNITY = 2; //pc社区

    public static final int LOGIN_TYPE_APP = 3; //app登录

    //社区默认的密码
    public static final String PASSWORD = "123456";

    //社区默认初始角色
    public static final String COMMUNITY_ROLE = "30f8d2eb12514bd4aaf847d2ebe1594d";
    //总后台最高角色
    public static final String ADMIN_ROLE = "9393b172278e449585d192ff72a02f88";


    //菜单权限所属type
    public static final Integer BACKEN_TYPE = 1; //总后台
    public static final Integer COMMUNITY_TYPE = 2; //社区

    //微信app id
    public static final String APPID = "wx6de76409aae82cdc";
    public static final String APPSECRET = "870320ddfec0ed3db24933b6a86abf56";


    /**
     * 积分
     */
    public static final Integer INIT_INTEGRAL = 20; //首次实名认证
}
