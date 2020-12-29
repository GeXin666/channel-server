package com.framework.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ServerInitializer extends ChannelInitializer<NioSocketChannel> {

    @Override
    protected void initChannel(NioSocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("log", new LoggingHandler(LogLevel.DEBUG));
        pipeline.addLast("eventHandler", EventHandler.INSTANCE);
        pipeline.addLast("fixedDecoder", new FixedLengthFrameDecoder(23));
        pipeline.addLast("protocolEncoder", TunnelProtocolDncoder.INSTANCE);
        pipeline.addLast("protocolMsgHandler", ProtocolMsgHandler.INSTANCE);
    }
}
