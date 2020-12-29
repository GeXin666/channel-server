package com.framework.config;

import com.framework.core.session.GuavaCacheSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;

@Configuration
public class SessionConfig {

    @Value("${app.config.session.timeout}")
    private Integer sessionTimeout;

    /**
     * 单机环境
     * 使用自定义仓库存储Session
     */
    @Configuration
    public class SpringBootLocalCacheHttpSessionConfiguration
        extends SpringHttpSessionConfiguration {

        @Autowired
        public void customize() {
            setHttpSessionIdResolver(new CookieHttpSessionIdResolver());
        }

        /**
         * 这里可以自定义Session仓库.可以集成EhCache.GuavaCahce
         * 注意:MapSessionRepository(new ConcurrentHashMap)不会回收内存，只能在测试时使用
         */
        @Bean
        public SessionRepository sessionRepository() {
            return new GuavaCacheSessionRepo("App-Session-Cache", sessionTimeout);
        }
    }

}
