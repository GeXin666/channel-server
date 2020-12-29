package com.framework.netty;

import com.framework.config.AppConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class NettyServer {

    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workerGroup = new NioEventLoopGroup(32);

    @PostConstruct
    public void startServer() throws Exception {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.ALLOCATOR, ByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.SO_KEEPALIVE, false)
                .childHandler(new ServerInitializer());
        b.bind("0.0.0.0", AppConfig.serverPort).sync();
        log.info("NettySocket Server started on port: {}", AppConfig.serverPort);
    }

    @PreDestroy
    public void stopServer() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        log.info("NettySocket Server stopped on port: {}", AppConfig.serverPort);
    }
}
