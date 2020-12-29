package com.framework.netty;

import com.framework.netty.message.ProtocolMsg;
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
        log.info("处理[隧道电伴热通讯协议]解码后的消息:{}", msg.toString());
    }
}
