package com.framework.core.convert;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.framework.core.annotation.JsonParam;
import org.springframework.core.MethodParameter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonParamParameterConvert implements HandlerMethodArgumentResolver {

	private ObjectMapper objectMapper;

	public JsonParamParameterConvert(ObjectMapper objectMapper) {
		Assert.notNull(objectMapper, "objectMapper must not be null");
		this.objectMapper = objectMapper;
	}
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(JsonParam.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, 
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		String parameterName = parameter.getParameterName();
		String jsonValue = webRequest.getParameter(parameterName);
		Class<?> parameterClass = parameter.getParameterType();
		
		if(!StringUtils.hasLength(jsonValue)) {
			if(parameterClass.isAssignableFrom(Map.class)) {
				return LinkedHashMap.class.newInstance();
			}
			return null;
 		}
		
		Object convertObject = null;
		JavaType javaType = null;
		
		if(Collection.class.isAssignableFrom(parameterClass)) {
			Type type = parameter.getGenericParameterType();
			if(type instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) type;
				Type elementType = parameterizedType.getActualTypeArguments()[0];
				Class<?> elementClass = null;
				if(elementType instanceof ParameterizedType) {
					elementClass = (Class<?>) ((ParameterizedType) elementType).getRawType();
				} else {
					elementClass = (Class<?>) elementType;
				}
				javaType = constructCollectionType((Class<? extends Collection<?>>)parameterClass, elementClass);
			}
		} 
		else if (parameterClass.isArray()) {
			Class<?> elementType = parameterClass.getComponentType();
			javaType = constructArrayType(elementType);
		} 
		else if(parameterClass.isAssignableFrom(Map.class)) {
			javaType = constructType(LinkedHashMap.class);
		} 
		else {
			javaType = constructType(parameterClass);
		}
		
		if(javaType != null) {
			convertObject = objectMapper.readValue(jsonValue, javaType);
		}
		
		return convertObject;
	}
	
	private JavaType constructCollectionType(Class<? extends Collection<?>> collectionClass, Class<?> elementClass) {
		return TypeFactory.defaultInstance().constructCollectionType(collectionClass, elementClass);
	}
	
	private JavaType constructArrayType(Class<?> elementType) {
		return TypeFactory.defaultInstance().constructArrayType(elementType);
	}
	
	private JavaType constructType(Class<?> type) {
		return TypeFactory.defaultInstance().constructType(type);
	}
	
}
