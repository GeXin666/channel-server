package com.framework.core.aspect;

//异常处理AOP >> 接口调用次数与平均时间AOP >> 接口调用时间AOP
//>>Ehcache缓存AOP >>数据库路由AOP >> 事务处理AOP
public class AspectOrder {

    //异常处理AOP
    public static final int ExceptionAspect = 1;

    //接口调用次数与平均时间AOP
    public static final int WatchAspect = 2;

    //接口调用时间AOP
    public static final int HealthAspect = 3;

    //Ehcache缓存AOP
    public static final int EnableCaching = 4;

    //数据库路由AOP
    public static final int DataSourceAspect = 6;

    //事务处理AOP
    public static final int EnableTransactionManagement = Integer.MAX_VALUE;

}
