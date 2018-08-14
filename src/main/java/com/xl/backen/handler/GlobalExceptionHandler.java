package com.xl.backen.handler;

import javax.validation.UnexpectedTypeException;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.xl.backen.controller")
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result handlerBusinessException(Exception e) {
        BusinessException businessException = (BusinessException) e;
        log.warn("业务异常: {}", e);
        return new Result<>(businessException.getCode(), businessException.getMsg());
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Result handlerHttpMediaTypeNotSupportedException(Exception e) {
        HttpMediaTypeNotSupportedException exception = (HttpMediaTypeNotSupportedException) e;
        return new Result(BusinessStatus.TYPE_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handlerMethodArgumentNotValidException(Exception e) {
        MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
        return new Result(BusinessStatus.PARAMETER_ERROR);
    }

    @ExceptionHandler(value = UnexpectedTypeException.class)
    @ResponseBody
    public Result handlerUnexpectedTypeException(Exception e) {
        UnexpectedTypeException exception = (UnexpectedTypeException) e;
        log.warn("字段校验异常",e);
        return new Result(BusinessStatus.VOLID_ERROR);
    }

    @ExceptionHandler(value = NotOfficeXmlFileException.class)
    @ResponseBody
    public Result handlerNotOfficeXmlFileException(Exception e) {
        log.warn("导入excel错误",e);
        NotOfficeXmlFileException notOfficeXmlFileException = (NotOfficeXmlFileException)e;
        return new Result(BusinessStatus.FILE_EXCEL_ERROR);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public Result handlerAuthenticationException(Exception e) {
        log.warn("shiro realm验证异常",e);
        AuthenticationException notOfficeXmlFileException = (AuthenticationException)e;
        return new Result(BusinessStatus.SHIRO_REAML_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        log.warn("未知异常",e);
        return new Result(BusinessStatus.ERROR);
    }
}
