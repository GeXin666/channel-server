package com.framework.core.aspect;

import com.framework.core.db.DataSource;
import com.framework.core.db.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(AspectOrder.DataSourceAspect)
public class DataSourceAspect extends BaseAspect{

    @Around("execution(public * com.framework.code.service..*.*(..)) && " +
            "@annotation(com.framework.core.db.DataSource)")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        try {
            MethodSignature ms = (MethodSignature) point.getSignature();
            DataSource ds = ms.getMethod().getAnnotation(DataSource.class);

            if(log.isDebugEnabled()) {
                log.debug("DB-Aspect DBType:[{}]", ds.type().value());
            }

            DynamicDataSource.setType(ds.type());
            return point.proceed();
        } finally {
            DynamicDataSource.clean();
        }
    }

}
