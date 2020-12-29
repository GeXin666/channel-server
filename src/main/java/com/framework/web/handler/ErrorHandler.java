package com.framework.web.handler;

import com.framework.core.bean.JsonResult;
import com.framework.core.excepton.BaseException;
import com.framework.core.excepton.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    /**
     * 系统异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public Object handlerExecption(Exception e) {
        JsonResult result = new JsonResult(false, "系统故障", ErrorCode.CODE_00000);
        result.putKeyValue("class", e.getClass());
        result.putKeyValue("error", e.getMessage());
        return result;
    }

    /**
     * 404异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Object handlerNotFoundException(NoHandlerFoundException e) {
        log.debug("NoHandlerFoundException code={} msg={}", "404", e.getMessage());
        JsonResult result = new JsonResult(false, "URL匹配不到资源");
        return result;
    }

    /**
     * 平台异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Object handlerBaseException(BaseException e) {
        String code = e.getCode();
        String msg = ErrorCode.getErrorMsg(code);
        log.debug("BaseException code={} msg={}", code, msg);
        JsonResult result = new JsonResult(false, msg, code);
        return result;
    }

    /**
     * 参数验证异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = BindException .class)
    public Object handlerBindException(BindException e) {
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.stream().forEach(x ->errorMsg.append(x.getDefaultMessage()).append(";"));
        JsonResult result = new JsonResult(false, errorMsg.toString());
        return result;
    }

    /**
     * Shiro权限异常
     */
    @ResponseBody
    @ExceptionHandler(value = UnauthenticatedException .class)
    public Object handlerUnauthenticatedException(UnauthenticatedException e) {
        JsonResult result = new JsonResult(false,
                ErrorCode.getErrorMsg(ErrorCode.CODE_00006),
                ErrorCode.CODE_00006);
        result.putKeyValue("class", e.getClass());
        result.putKeyValue("error", e.getMessage());
        return result;
    }

    /**
     * Shiro权限异常
     */
    @ResponseBody
    @ExceptionHandler(value = AuthorizationException .class)
    public Object handlerAuthorizationException(AuthorizationException e) {
        JsonResult result = new JsonResult(false,
                ErrorCode.getErrorMsg(ErrorCode.CODE_00005),
                ErrorCode.CODE_00005);
        result.putKeyValue("class", e.getClass());
        result.putKeyValue("error", e.getMessage());
        return result;
    }

}
