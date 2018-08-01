package com.xl.backen.handler;

/**
 * 业务逻辑状态码
 */
public enum BusinessStatus {
    //错误码
    ERROR(-1, "未知错误"),

    //4开头错误码
    USERNAME_REQ(400, "用户名是必须的"),
    PASSWORD_REQ(401, "密码是必须的"),
    TYPE_ERROR(402, "表单方式提交是不支持的"),
    VOLID_ERROR(402, "字段校验未通过"),
    PARAMETER_ERROR(499, "参数异常"),
    
    //5开头后台错误
    SERVER_ERROR5(500, "空指针异常"),
    

    //权限类异常
    USER_ERROR(2001, "没有此用户"),
    PASSWORD_ERROR(2002, "密码错误"),
    POWER_ERROR(2003,"没有操作权限"),
    LOGIN_ERROR(2004, "必须登陆"),
    UUID_REQ(2005, "uuid是必须的"),
    MOBILE_ERROR(2006, "手机号码已注册"),
    ROLE_ERROR(2007,"角色下面存在用户，不能进行删除"),
    DEL_OPEAR_ERROR(2008, "不能通过修改接口直接更改status状态"),

    /**
     * 任务活动模块异常
     */
    TIME_ERROR(3001, "结束时间不能小于等于开始时间"),
    TIME_NOW_ERROR(3001, "时间不能小于等于目前时间"),

    //工具类异常
    MD5_ERROR(5000, "MD5加密异常"),
    VERIFY_ERROR(5001, "MD5解密异常"),
    IMPORT_ERROR(5002, "excel导入格式异常"),

    //数据库异常
    UPDATE_ERROR(10001, "数据库修改异常"),
    INSERT_ERROR(10002, "数据库新增异常"),

    //文件上传异常
    FILEUPLOAD_ERROR(2001, "文件上传异常"),

    //展示
    SUCCESS(200, "成功");

    BusinessStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
