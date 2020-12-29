package com.framework.core.jackson;

import java.util.Date;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class SimpleModuleRegistry extends SimpleModule {

	private static final long serialVersionUID = -7564876712691825182L;

	public SimpleModuleRegistry() {
		addDeserializer(Date.class, new DateDeserializer());
		addSerializer(Date.class, new DateSerializer());
	}
	
}
