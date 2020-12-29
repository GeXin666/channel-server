package com.framework.core.convert;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class JsonHttpMessageConvert extends MappingJackson2HttpMessageConverter {

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return (!byte[].class.equals(clazz))
				&& (!String.class.equals(clazz))
				&& super.canRead(clazz, mediaType);
	}
	
}
