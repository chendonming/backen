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
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice(basePackages = "com.xl.backen.controller")
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result<String> handlerBusinessException(Exception e) {
        BusinessException businessException = (BusinessException) e;
        log.warn("业务异常: {}", e);
        return new Result<String>(businessException.getCode(), businessException.getMsg());
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Result<Object> handlerHttpMediaTypeNotSupportedException(Exception e) {
        return new Result<Object>(BusinessStatus.TYPE_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Object> handlerMethodArgumentNotValidException(Exception e) {
        return new Result<Object>(BusinessStatus.PARAMETER_ERROR);
    }

    @ExceptionHandler(value = UnexpectedTypeException.class)
    @ResponseBody
    public Result<Object> handlerUnexpectedTypeException(Exception e) {
        log.warn("字段校验异常",e);
        return new Result<Object>(BusinessStatus.VOLID_ERROR);
    }

    @ExceptionHandler(value = NotOfficeXmlFileException.class)
    @ResponseBody
    public Result<Object> handlerNotOfficeXmlFileException(Exception e) {
        log.warn("导入excel错误",e);
        return new Result<Object>(BusinessStatus.FILE_EXCEL_ERROR);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public Result<Object> handlerAuthenticationException(Exception e) {
        log.warn("shiro realm验证异常",e);
        return new Result<Object>(BusinessStatus.SHIRO_REAML_ERROR);
    }

    @ExceptionHandler(value = MultipartException.class)
    @ResponseBody
    public Result<Object> handlerMultipartException(Exception e) {
        log.warn("文件异常",e);
        return new Result<Object>(BusinessStatus.FILE_EXIST_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handler(Exception e) {
        log.warn("未知异常",e);
        return new Result<String>(BusinessStatus.ERROR,e.getMessage());
    }
}
