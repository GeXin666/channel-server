package com.framework.core.jackson;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * http://ketao1989.github.io/posts/Jackson-Manual-and-Implementation-Analyzing.html
 */
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper>,
		InitializingBean {

	/**
     * 该特性决定了当遇到未知属性（没有映射到属性，没有任何setter或者任何可以处理它的handler），是否应该抛出一个
     * JsonMappingException异常。这个特性一般式所有其他处理方法对未知属性处理都无效后才被尝试，属性保留未处理状态。
     * 默认情况下，该设置是被打开的。
     */
	private static final boolean FAIL_ON_UNKNOWN_PROPERTIES = false;
	
	/**
     * 该特性决定对Enum 枚举值使用标准的序列化机制。如果true，则返回Enum.toString()值，否则为Enum.name()
     */
	private static final boolean WRITE_ENUMS_USING_TO_STRING = true;
	
	
	private ObjectMapper objectMapper;
	
	private String dateformat = "yyyy-MM-dd HH:mm";
	
	//Include.NON_DEFAULT || Include.NON_EMPTY || Include.NON_NULL
	private Include include = Include.ALWAYS; //default
	
	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.objectMapper = buildObjectMapper();
	}
	
	protected ObjectMapper buildObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, WRITE_ENUMS_USING_TO_STRING);
		
		objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		
		if(dateformat != null) {
			objectMapper.setDateFormat(new SimpleDateFormat(dateformat));
		}
		
		objectMapper.setSerializationInclusion(include);

		//null值序列化写成""
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				gen.writeString("");
			}
		});

		//objectMapper.registerModule(new SimpleModuleRegistry());
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
		//simpleModule.addSerializer(Double.class, new DoubleSerialize());
		//simpleModule.addSerializer(Double.TYPE, new DoubleSerialize());
		objectMapper.registerModule(simpleModule);

		return objectMapper;
	}
	
	@Override
	public ObjectMapper getObject() throws Exception {
		if (objectMapper == null) {
			afterPropertiesSet();
		}
		return this.objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return this.objectMapper == null ? ObjectMapper.class : this.objectMapper.getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
