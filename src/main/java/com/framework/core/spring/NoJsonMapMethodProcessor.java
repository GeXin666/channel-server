package com.framework.core.spring;

import com.framework.core.annotation.Json;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.annotation.MapMethodProcessor;

import java.util.Map;

public class NoJsonMapMethodProcessor extends MapMethodProcessor {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Json.class) == null
                && Map.class.isAssignableFrom(parameter.getParameterType());
    }

}
