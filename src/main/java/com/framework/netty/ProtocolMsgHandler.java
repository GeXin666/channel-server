package com.framework.netty;

import com.framework.core.spring.SpringUtils;
import com.framework.netty.message.ProtocolMsg;
import com.google.common.eventbus.EventBus;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ChannelHandler.Sharable
public class ProtocolMsgHandler extends SimpleChannelInboundHandler<ProtocolMsg> {

    public static final ProtocolMsgHandler INSTANCE = new ProtocolMsgHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtocolMsg msg) {
        SpringUtils.getBean(EventBus.class).post(msg);
    }
}
