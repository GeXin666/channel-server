package com.framework.core.convert;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 日期参数转换器
 */
public class StringToDateConvert implements Converter<String, Date> {

	private final static String shortPattern = "yyyy-MM-dd";
	private final static String middlePattern = "yyyy-MM-dd HH:mm";
	private final static String longPattern = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public Date convert(String source) {
		if(StringUtils.hasText(source)) {
			try {
				return autoMatch(source);
			} catch (Exception e) {
				throw new IllegalArgumentException("this argument's format must be yyyy-MM-dd or yyyy-MM-dd HH:mm:ss");
			}
		}
		return null;
	}

	private Date autoMatch(String strDate) {
		
		DateTimeFormatter formatter;
		int len = strDate.length();
		
		if(len == 10) {
			formatter = DateTimeFormat.forPattern(shortPattern);
		} else if(len == 16) {
			formatter = DateTimeFormat.forPattern(middlePattern);
		} else {
			formatter = DateTimeFormat.forPattern(longPattern);
		}
		
		return DateTime.parse(strDate, formatter).toDate();
	}
}
