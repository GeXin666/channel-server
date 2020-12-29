package com.framework.web.eventbus;

import com.framework.web.eventbus.event.ErrorLogEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogSubscribe {

    @Subscribe
    @AllowConcurrentEvents
    public void subscribeErrorLogEvent(ErrorLogEvent event) {
        if(log.isErrorEnabled()) {
            log.error("subscribeErrorLogEvent -> " + event, event.getThrowable());
        }
    }
}
