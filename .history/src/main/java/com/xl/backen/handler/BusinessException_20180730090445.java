package com.xl.backen.handler;

public class BusinessException extends RuntimeException {
	
    private Integer code;

    private String msg;

    public BusinessException(BusinessStatus businessStatus) {
        this.code = businessStatus.getCode();
        this.msg = businessStatus.getMsg();
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
}
