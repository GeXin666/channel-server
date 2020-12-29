package com.framework.netty.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolMsg {

    private String ip; //设备IP
    private int port; //设备端口

    private byte sbdz; //设备地址
    private byte gnm;  //功能码
    private byte length;//数据字节长度
    private int csbb; //参数版本

    private byte wenkzt1; //温控状态1
    private byte wenkzt2; //温控状态2
    private byte wenkzt3; //温控状态3

    private byte jiarzt1; //加热状态1
    private byte jiarzt2; //加热状态2
    private byte jiarzt3; //加热状态3

    private short wend1; //温度1
    private short wend2; //温度2
    private short wend3; //温度3
    private short shid; //湿度
    private short gongzms; //工作模式

    @Override
    public String toString() {
        return "ProtocolMsg{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", sbdz=" + sbdz +
                ", gnm=" + gnm +
                ", length=" + length +
                ", csbb=" + csbb +
                ", wenkzt1=" + wenkzt1 +
                ", wenkzt2=" + wenkzt2 +
                ", wenkzt3=" + wenkzt3 +
                ", jiarzt1=" + jiarzt1 +
                ", jiarzt2=" + jiarzt2 +
                ", jiarzt3=" + jiarzt3 +
                ", wend1=" + wend1 +
                ", wend2=" + wend2 +
                ", wend3=" + wend3 +
                ", shid=" + shid +
                ", gongzms=" + gongzms +
                '}';
    }
}
