package com.framework.generate.mybaits;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

/**
 * Mybaits代码生成类型转换器
 */
public class MyBatisTypeConvert implements JavaTypeResolver {

    JavaTypeResolverDefaultImpl impl = new JavaTypeResolverDefaultImpl();

    public void addConfigurationProperties(Properties arg0) {
        impl.addConfigurationProperties(arg0);
    }

    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn arg0) {
        FullyQualifiedJavaType answer;
        if (arg0.getJdbcType() == Types.OTHER) {
            answer = new FullyQualifiedJavaType(String.class.getName());
        } else {
            answer = impl.calculateJavaType(arg0);
        }
        return answer;
    }

    public String calculateJdbcTypeName(IntrospectedColumn col) {
        String answer;
        if (col.getJdbcType() == Types.OTHER) {
            answer = "VARCHAR";
        } else if (col.getJdbcType() == Types.DATE) {
            answer = "TIMESTAMP";
        } else {
            answer = impl.calculateJdbcTypeName(col);
        }
        return answer;
    }

    public void setContext(Context arg0) {
        impl.setContext(arg0);
    }

    public void setWarnings(List<String> arg0) {
        impl.setWarnings(arg0);
    }

}
