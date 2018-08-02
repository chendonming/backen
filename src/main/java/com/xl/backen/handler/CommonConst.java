package com.xl.backen.handler;

/**
 * 常量类
 */
public class CommonConst {
    public static final String USER_SESSION = "activeUser";
    
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
}
