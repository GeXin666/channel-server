package com.framework.web.eventbus.event;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 记录系统错误信息的事件对象
 */
@Data
public class ErrorLogEvent {

    private String threadName;
    private String className;
    private String methodName;
    private Map<String, Object> argsMap;
    private String argsJson;
    private Date happenTime;
    private Throwable throwable;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "ErrorLogEvent{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", argsJson=" + argsJson +
                ", happenTime=" + sdf.format(happenTime) +
                '}';
    }
}
