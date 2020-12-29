package com.framework.core.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

/**
 * 基本类型转换器
 */
public class StringToNumberConvert implements ConverterFactory<String, Number> {

	private static final String ZERO = "0";
	
	@Override
	public <T extends Number> Converter<String, T> getConverter(
			Class<T> targetType) {
		
		return new StringToNumber<T>(targetType);
	}
	
	private static final class StringToNumber<T extends Number> implements Converter<String, T> {

		private final Class<T> targetType;

		public StringToNumber(Class<T> targetType) {
			this.targetType = targetType;
		}

		public T convert(String source) {
			if(!StringUtils.hasText(source)) {
				source = ZERO;
			}
			
			return NumberUtils.parseNumber(source, this.targetType);
		}
	}
}
