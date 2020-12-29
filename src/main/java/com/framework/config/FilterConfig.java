package com.framework.config;

import com.framework.web.filter.MyShiroFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    /**
     * 处理字符集
     */
    @Bean
    public FilterRegistrationBean charsetFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        registration.setFilter(filter);
        registration.setName("characterEncodingFilter");
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 管理Session
     */
    @Bean
    public FilterRegistrationBean sessionRepositoryFilter(SessionRepositoryFilter<?> filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setName("sessionRepositoryFilter");
        registration.setOrder(2);
        registration.addUrlPatterns("/*", "/session/*");
        return registration;
    }

    /**
     * 处理Shiro权限
     */
    @Bean
    public FilterRegistrationBean myShiroFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyShiroFilter());
        registration.setName("myShiroFilter");
        registration.setOrder(4);
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD,
                DispatcherType.INCLUDE, DispatcherType.ERROR);
        return registration;
    }

    /**
     * Shiro拦截器
     */
    @Bean
    public FilterRegistrationBean springShiroFilter(ShiroFilterFactoryBean shiroFilterFactoryBean) throws Exception {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter((Filter) shiroFilterFactoryBean.getObject());
        registration.setName("springShiroFilter");
        registration.setOrder(5);
        registration.addUrlPatterns("/*", "/shiro/*");
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD,
                DispatcherType.INCLUDE, DispatcherType.ERROR);
        return registration;
    }

}
