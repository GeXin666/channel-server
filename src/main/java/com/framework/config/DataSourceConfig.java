package com.framework.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    //@Bean(name = "dataSource")
    public DataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setUser("root");
            ds.setPassword("Sql2008!@#");
            ds.setJdbcUrl("jdbc:mysql://192.168.80.111:3306/pay_center?verifyServerCertificate=false&useUnicode=true&useSSL=false");
            //如果 breakAfterAcquireFailure=true ，一旦pool向数据库请求连接失败，就会标记pool block并关闭pool，
            //这样无论数据库是否恢复正常，应用端都无法从pool拿到连接
            ds.setBreakAfterAcquireFailure(false);

            //连接池中保留的最小连接数，默认为3
            ds.setMinPoolSize(20);

            //连接池中保留的最大连接数。默认值15
            ds.setMaxPoolSize(50);

            //初始化连接池中的连接数  大于等于 minPoolSize
            ds.setInitialPoolSize(20);

            //最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0
            ds.setMaxIdleTime(60);

            //表示 connection能存活的绝对时间
            ds.setMaxConnectionAge(0);

            //当连接池连接耗尽时，客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，如设为0则无限期等待。单位毫秒。默认: 0
            ds.setCheckoutTimeout(3000);

            //当连接池中的连接耗尽的时候c3p0 一次同时获取的连接数,默认值: 3
            ds.setAcquireIncrement(10);

            //定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次
            ds.setAcquireRetryAttempts(0);

            //重新尝试的时间间隔，默认为：1000毫秒
            ds.setAcquireRetryDelay(2000);

            //每60秒检查所有连接池中的空闲连接。默认值: 0，不检查
            ds.setIdleConnectionTestPeriod(60);

            //c3p0将建一张名为C3p0TestTable_NotDelete的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。
            //你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。默认值: null
            ds.setAutomaticTestTable("C3p0TestTable_NotDelete");

            //关闭连接时，是否提交未提交的事务，默认为false，即关闭连接，回滚未提交的事务
            ds.setAutoCommitOnClose(false);

            //true表示在每次从pool内checkout连接的时候测试其有效性，这是个同步操作，因此应用端的每次数据库调用，
            //都会先通过测试sql测试其有效性，如果连接无效，会关闭此连接并剔除出pool，
            //并尝试从pool内取其他连接，默认为false，此特性要慎用，会造成至少多一倍的数据库调用。
            ds.setTestConnectionOnCheckout(false);

            //true表示每次把连接checkin到pool里的时候测试其有效性，
            //因为是个事后操作，所以是异步的，应用端不需要等待测试结果，但同样会造成至少多一倍的数据库调用。
            ds.setTestConnectionOnCheckin(false);

            ds.setNumHelperThreads(3);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return ds;
    }

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "dbcommon.master")
    public DataSource dbcommonMaster() {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

}
