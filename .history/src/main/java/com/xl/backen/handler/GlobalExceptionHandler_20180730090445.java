package com.xl.backen.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice(basePackages = "com.xl.volunteer.controller")
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerBusinessException(Exception e) {
        log.info("异常参数: {}", e);
        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException)e;
            log.warn("业务异常: {}", e);
            return new Result(businessException.getCode(), businessException.getMsg());
        } else if(e instanceof HttpMediaTypeNotSupportedException){
            return new Result(BusinessStatus.TYPE_ERROR);
        } else if(e instanceof MethodArgumentNotValidException) {
            log.warn("异常: {}", e);
            return new Result(BusinessStatus.PARAMETER_ERROR);
        }else if(e instanceof NullPointerException) {
        	log.warn("空指针异常");
        	return new Result(BusinessStatus.SERVER_ERROR5);
        }else {
            log.warn("异常: {}", e);
            return new Result(BusinessStatus.ERROR);
        }
    }
}
