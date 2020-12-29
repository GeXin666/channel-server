package com.framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.core.convert.*;
import com.framework.core.jackson.ObjectMapperFactoryBean;
import com.framework.core.spring.CustomRequestMappingHandlerAdapter;
import com.framework.web.listener.WebListener;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 添加静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加Controller拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //检查Sql注入拦截器
        //registry.addInterceptor(new SqlInjectInterceptor()).addPathPatterns("/**");
    }

    /**
     * 添加参数转换器
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PaginationParamConvert());
        argumentResolvers.add(new JsonParamParameterConvert(objectMapper));
        argumentResolvers.add(new JsonParameterConvert());
        argumentResolvers.add(new XmlParameterConvert());
    }

    /**
     * 使用Apache-FileUpload组件上传
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024 * 1024 * AppConfig.maxUploadSize);
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setUploadTempDir(new FileSystemResource(AppConfig.uploadTempDir));
        multipartResolver.setMaxInMemorySize(AppConfig.maxInMemorySize);
        return multipartResolver;
    }

    /**
     * 添加类型转换器
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConvert());
        registry.addConverterFactory(new StringToNumberConvert());
    }

    /**
     * 添加JSON类型转换器
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        JsonHttpMessageConvert convert = new JsonHttpMessageConvert();
        convert.setObjectMapper(objectMapper);
        converters.add(convert);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
    }

    /**
     * 自定义JackMapper
     */
    @Bean
    public FactoryBean<ObjectMapper> objectMapper() {
        return new ObjectMapperFactoryBean();
    }

    /**
     * 重写RequestMappingHandlerAdapter
     */
    @Override
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return new CustomRequestMappingHandlerAdapter();
    }

    /**
     * 设置允许跨域
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许跨域的头信息
                .allowedHeaders("*")
                //允许跨域的Method
                .allowedMethods("*")
                //Access-Control-Max-Age 预检请求结果的缓存时间(秒)
                .maxAge(1800)
                //暴露给客户端的Header
                .exposedHeaders("X-Auth-Token")
                //允许跨域的来源
                .allowedOrigins("*");
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new WebListener());
        return bean;
    }
}
