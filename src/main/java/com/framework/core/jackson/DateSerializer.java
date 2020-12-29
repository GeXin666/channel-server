package com.framework.core.jackson;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer  extends JsonSerializer<Date>  {

	private final static String shortPattern = "yyyy-MM-dd";
	
	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException {
		String outValue = new DateTime(value).toString(shortPattern);
		jgen.writeString(outValue);
	}

}
