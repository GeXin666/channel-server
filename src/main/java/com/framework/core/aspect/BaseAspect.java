package com.framework.core.aspect;

import com.framework.core.annotation.LogArgs;
import com.framework.core.excepton.DBRouteExecption;
import com.framework.core.excepton.ErrorCode;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseAspect {

    private Map<Method, Integer> routingKeyIndexCache = new ConcurrentHashMap();

    public Map<String, Object> getLogParams(LogArgs logArgs, String[] argsNames, Object[] argsValues) {
        Map<String, Object> argsMap = new LinkedHashMap<>();

        if(logArgs != null && logArgs.name().length > 0) {
            List<String> logAgsNames = Arrays.asList(logArgs.name());
            for (int i = 0; i < argsNames.length; i++) {
                String argsName = argsNames[i];
                if(logAgsNames.contains(argsName)) {
                    argsMap.put(argsName, argsValues[i]);
                }
            }
        }

        return argsMap;
    }

    public int findKeyIndex(Method method, String routingKey, String[] argsNames) {
        Integer routingKeyIndex = routingKeyIndexCache.get(method);
        if(routingKeyIndex != null) {
            return routingKeyIndex.intValue();
        }

        for (int i = 0; i < argsNames.length; i++) {
            String argsName = argsNames[i];
            if(routingKey.equals(argsName)) {
                routingKeyIndexCache.putIfAbsent(method, new Integer(i));
                return i;
            }
        }

        throw new DBRouteExecption(ErrorCode.CODE_00008);
    }

}
