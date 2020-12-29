package com.framework.core.aspect;

import com.framework.core.annotation.LogArgs;
import com.framework.core.excepton.OperationException;
import com.framework.core.uitls.AppUtil;
import com.framework.web.eventbus.event.ErrorLogEvent;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Aspect
@Component
@Order(AspectOrder.ExceptionAspect)
public class ExceptionAspect extends BaseAspect {

    @Autowired
    private EventBus eventBus;

    @Around("execution(public * com.framework.code.controller..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Throwable e) {
            if(!(e instanceof OperationException) && !(e instanceof UnauthenticatedException)) {
                broadcastErrotLog(point, e);
            }
            throw e;
        }
    }

    private void broadcastErrotLog(ProceedingJoinPoint point, Throwable throwable) {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();

        String methodName = method.getName();
        String className = point.getTarget().getClass().getSimpleName();

        LogArgs logArgs = method.getAnnotation(LogArgs.class);
        Map<String, Object> argsMap = getLogParams(logArgs, ms.getParameterNames(), point.getArgs());

        //构造错误日志事件
        ErrorLogEvent event = new ErrorLogEvent();
        event.setThreadName(Thread.currentThread().getName());
        event.setClassName(className);
        event.setMethodName(methodName);
        event.setHappenTime(new Date());
        event.setArgsMap(argsMap);
        event.setArgsJson(AppUtil.toJson(argsMap));
        event.setThrowable(throwable);
        eventBus.post(event);
    }
}
