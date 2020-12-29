package com.framework.web.eventbus;

import com.framework.code.service.JcShebService;
import com.framework.netty.message.ProtocolMsg;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ProtocolMsgSubscribe {

    @Autowired
    private JcShebService jcShebService;

    @Subscribe
    @AllowConcurrentEvents
    public void subscribe(ProtocolMsg event) {
        if(log.isInfoEnabled()) {
            log.info("异步处理[隧道电伴热通讯协议]解码后的消息:{}", event.toString());
        }
        jcShebService.processProtocolMsg(event);
    }
}
