package com.framework.config;

import com.framework.core.mybatis.MySqlPagingInterceptor;
import com.framework.core.mybatis.MySqlSessionFactoryBean;
import com.framework.core.mybatis.type.StringArrayTypeHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage = "com.framework.code.domain";

    @Value("${mybatis.mapperBasePackage}")
    private String mapperBasePackage = "com.framework.code.mapper";

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource ds) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(ds);
        //是否支持还原点
        transactionManager.setNestedTransactionAllowed(false);
        return transactionManager;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public MySqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource")DataSource ds) {
        MySqlSessionFactoryBean factoryBean = new MySqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        //分页插件
        factoryBean.setPlugins(new Interceptor[]{new MySqlPagingInterceptor()});
        //实体类包路径
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);
        //类型转换器
        factoryBean.setTypeAliases(new Class[]{String[].class});
        factoryBean.setTypeHandlers(new TypeHandler[]{new StringArrayTypeHandler()});
        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScanner.setBasePackage(mapperBasePackage);
        return mapperScanner;
    }
}
