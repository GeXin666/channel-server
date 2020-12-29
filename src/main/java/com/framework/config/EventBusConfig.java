package com.framework.config;

import com.framework.web.eventbus.LogSubscribe;
import com.framework.web.eventbus.ProtocolMsgSubscribe;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class EventBusConfig {

    @Bean
    public EventBus registerEventBus() {
        AsyncEventBus eventBus = new AsyncEventBus(AppConfig.eventBusName,
                                            Executors.newFixedThreadPool(AppConfig.eventBusThreadCount));
        eventBus.register(logSubscribe());
        eventBus.register(msgSubscribe());
        return eventBus;
    }

    @Bean
    public LogSubscribe logSubscribe() {
        return new LogSubscribe();
    }

    @Bean
    public ProtocolMsgSubscribe msgSubscribe() {
        return new ProtocolMsgSubscribe();
    }
}
