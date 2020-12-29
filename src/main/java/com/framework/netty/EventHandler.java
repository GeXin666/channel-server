package com.framework.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ChannelHandler.Sharable
public class EventHandler extends ChannelInboundHandlerAdapter {

    public static final EventHandler INSTANCE = new EventHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("ChannelActive: {}", ctx.channel().toString());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelInactive: {}", ctx.channel().toString());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("exceptionCaught:{}", ctx.channel().toString(), cause);
        ctx.channel().close();
        super.exceptionCaught(ctx, cause);
    }
}
