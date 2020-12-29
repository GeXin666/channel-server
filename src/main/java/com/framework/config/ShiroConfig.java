package com.framework.config;

import com.framework.core.shiro.*;
import com.framework.web.shiro.AuthcListener;
import com.framework.web.shiro.LoginRealm;
import com.framework.web.shiro.WeChatLoginRealm;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 认证器
     */
    @Bean
    public Realm loginRealm() {
        LoginRealm realm = new LoginRealm();
        realm.setCacheManager(shiroCacheManager());
        return realm;
    }

    @Bean
    public Realm weChatLoginRealm() {
        WeChatLoginRealm weChatLoginRealm = new WeChatLoginRealm();
        weChatLoginRealm.setCacheManager(shiroCacheManager());
        return weChatLoginRealm;
    }


    /**
     * 缓存管理器
     */
    @Bean(name = "shiroCacheManager")
    public CacheManager shiroCacheManager() {
        return new SessionCacheManager();
    }

    /**
     * Web安全管理器
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSubjectDAO(new DefaultSubjectDAO());
        securityManager.setSubjectFactory(new DefaultWebSubjectFactory());
        securityManager.setRememberMeManager(new CookieRememberMeManager());
        securityManager.setSessionManager(new ServletContainerSessionManager());
        securityManager.setAuthenticator(authenticator());
        securityManager.setAuthorizer(new ModularRealmAuthorizer());
        List<Realm> realms = new ArrayList<>();
        realms.add(loginRealm());
        realms.add(weChatLoginRealm());
        securityManager.setRealms(realms);
        //securityManager.setEventBus(eventBus);
        securityManager.setCacheManager(shiroCacheManager());
        return securityManager;
    }

    /**
     * Shiro拦截Filter
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setLoginUrl("/login.jsp");
        filterFactoryBean.setSuccessUrl("/successUr.jsp");
        filterFactoryBean.setUnauthorizedUrl("/unauthorizedUr.jsp");
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        filterFactoryBean.setFilters(shiroFilter());
        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        return filterFactoryBean;
    }

    /**
     * 拦截规则定义
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition cf = new DefaultShiroFilterChainDefinition();
        //cf.addPathDefinition("/HivetestController/**", "myLogin");
        //cf.addPathDefinition("/HivetestController/**", "myRole[admin]");
        //cf.addPathDefinition("/HivetestController/deleteByPrimaryKey", "MyPerm[delete]");
        cf.addPathDefinition("/Test2Controller/selectPageMap", "myRole[admin]");
        return cf;
    }

    /**
     * 自定义Shiro-Filter拦截器
     */
    public Map<String, Filter> shiroFilter() {
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("myLogin", new MyLoginFilter());
        filterMap.put("myUser", new MyUserFilter());
        filterMap.put("myRole", new MyRoleFilter());
        filterMap.put("MyPerm", new MyPermissionFilter());
        return filterMap;
    }

    /**
     * 认证策略
     */
    @Bean
    public AuthenticationStrategy authenticationStrategy() {
        return new FirstSuccessfulStrategy();
    }

    @Bean
    public Authenticator authenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(authenticationStrategy());
        List<AuthenticationListener> listeners = new ArrayList<>();
        listeners.add(authcListener());
        authenticator.setAuthenticationListeners(listeners);
        return authenticator;
    }

    /**
     * 认证事件
     */
    @Bean
    public AuthenticationListener authcListener() {
        AuthcListener authcListener = new AuthcListener();
        return authcListener;
    }

    /**
     * Shiro注解拦截AOP
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}

