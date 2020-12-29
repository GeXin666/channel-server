package com.framework.core.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数组类型转换器
 */
@MappedTypes(String[].class)
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String[] parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, arrayToDelimitedString(parameter, ","));
	}
	
	@Override
	public String[] getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		String value = rs.getString(columnName);
		if(value != null) {
			return value.split(",");
		}
		return null;
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String value = rs.getString(columnIndex);
		if(value != null) {
			return value.split(",");
		}
		return null;
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String value = cs.getString(columnIndex);
		if(value != null) {
			return value.split(",");
		}
		return null;
	}

	private String arrayToDelimitedString(String[] arr, String delim) {
		if(arr == null || arr.length == 0) {
			return "";
		}
		if (arr.length == 1) {
			return arr[0];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
