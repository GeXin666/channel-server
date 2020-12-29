package com.framework.netty;

import com.framework.core.excepton.OperationException;
import com.framework.core.uitls.AppUtil;
import com.framework.netty.message.ProtocolMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
@ChannelHandler.Sharable
public class TunnelProtocolDncoder extends SimpleChannelInboundHandler<ByteBuf> {

    public static final TunnelProtocolDncoder INSTANCE = new TunnelProtocolDncoder();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) {
        log.info("开始解码[隧道电伴热通讯协议] HEX:[{}]", ByteBufUtil.hexDump(buf).toUpperCase());

        byte[] crcBytes = ByteBufUtil.getBytes(buf, 0, 21);
        InetSocketAddress ipSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        final String clientIp = ipSocket.getAddress().getHostAddress();
        final int clientPort = ipSocket.getPort();

        ProtocolMsg msg = new ProtocolMsg();
        msg.setIp(clientIp);
        msg.setPort(clientPort);
        msg.setSbdz(buf.readByte());
        msg.setGnm(buf.readByte());
        msg.setLength(buf.readByte());
        //参数版本 2字节 按无符号读取
        msg.setCsbb(buf.readUnsignedShort());
        //温控状态1-3
        msg.setWenkzt1(buf.readByte());
        msg.setWenkzt2(buf.readByte());
        msg.setWenkzt3(buf.readByte());
        //加热状态1-3
        msg.setJiarzt1(buf.readByte());
        msg.setJiarzt2(buf.readByte());
        msg.setJiarzt3(buf.readByte());
        //温度1-3
        msg.setWend1(buf.readShort());
        msg.setWend2(buf.readShort());
        msg.setWend3(buf.readShort());
        msg.setShid(buf.readShort());
        msg.setGongzms(buf.readShort());

        int crcValue1 = buf.readUnsignedShort();
        int ctcValue2 = AppUtil.getCRC(crcBytes);
        if(crcValue1 != ctcValue2) {
            log.warn("CRC验证失败 crcValue1:{} ctcValue2:{}", crcValue1, ctcValue2);
            ctx.channel().pipeline().fireExceptionCaught(new OperationException("CRC验证失败"));
        }
        ctx.fireChannelRead(msg);
    }
}
