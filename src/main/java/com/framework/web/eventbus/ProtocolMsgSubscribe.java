package com.framework.web.eventbus;

import com.framework.netty.message.ProtocolMsg;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProtocolMsgSubscribe {

    @Subscribe
    @AllowConcurrentEvents
    public void subscribe(ProtocolMsg event) {
    }
}
