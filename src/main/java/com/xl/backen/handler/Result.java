package com.xl.backen.handler;

/**
 * 统一数据展示
 */
public class Result<T> {

    /**
     * 状态码展示
     */
    private Integer code;

    /**
     * 信息展示
     */
    private String msg;

    /**
     * 数据结果展示
     */
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Result(BusinessStatus businessStatus) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
    }


    public Result(BusinessStatus businessStatus, T data) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
