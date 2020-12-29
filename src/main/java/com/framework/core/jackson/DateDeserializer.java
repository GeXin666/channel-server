package com.framework.core.jackson;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserializer extends JsonDeserializer<Date> {

	private final static String shortPattern = "yyyy-MM-dd";
	private final static String longPattern = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if(jp.getCurrentToken() == JsonToken.VALUE_STRING) {
			String value = jp.getText();
			if(StringUtils.hasText(value)) {
				try {
					return autoMatch(value);
				} catch (Exception e) {
					throw new IllegalArgumentException("this argument's format must be yyyy-MM-dd or yyyy-MM-dd HH:mm:ss");
				}
			}
			return null;

		}
		throw new JsonMappingException(jp, "Expected JSON String");
	}
	
	private Date autoMatch(String strDate) {
		DateTimeFormatter formatter = null;
		if(strDate.length() == 10) {
			formatter = DateTimeFormat.forPattern(shortPattern);
		} else {
			formatter = DateTimeFormat.forPattern(longPattern);
		}
		return DateTime.parse(strDate, formatter).toDate();
	}

}
