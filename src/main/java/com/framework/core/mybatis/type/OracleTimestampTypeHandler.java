package com.framework.core.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;

/**
 * Oracle.TIMESTAMP类型转换器
 */
//@MappedTypes(TIMESTAMP.class)
@MappedJdbcTypes(value=JdbcType.TIMESTAMP)
public class OracleTimestampTypeHandler extends BaseTypeHandler<Timestamp> {
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Timestamp parameter, JdbcType jdbcType) throws SQLException {
		 ps.setTimestamp(i, parameter);
	}

	@Override
	public Timestamp getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return rs.getTimestamp(columnName);
	}

	@Override
	public Timestamp getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return rs.getTimestamp(columnIndex);
	}

	@Override
	public Timestamp getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return cs.getTimestamp(columnIndex);
	}
	
}
