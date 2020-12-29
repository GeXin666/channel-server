package com.framework.core.uitls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.core.spring.SpringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.*;

public final class AppUtil {

    /**
     * 获取异常的具体信息
     * @param t 异常信息
     * @return 带格式的错误信息
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.getBuffer().toString().replaceAll("\\$", "T");
    }

    /**
     * 过滤sql特殊字符 防止注入
     * @param sql 原始字符串
     * @return 过滤后的字符串
     */
    public static String sqlClean(String sql) {
        return sql.replaceAll(".*([';]+|(--)+).*", " ");
    }

    /**
     * ip转换int值
     * @param strIp IP地址
     * @return int类型值
     */
    public static int ipToInt(String strIp) {
        String[] ip = strIp.split("\\.");
        return Integer.parseInt(ip[0]) << 24
                | Integer.parseInt(ip[1]) << 16
                | Integer.parseInt(ip[2]) << 8
                | Integer.parseInt(ip[3]);
    }

    /**
     * int转为ip地址
     * @param intIp int类型ip地址
     * @return string类型值
     */
    public static String intToIp(int intIp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int v = intIp >>> (24 - (8 * i)) & 0xff;
            sb.append(v);
            if (i < 3) sb.append(".");
        }
        return sb.toString();
    }

    /**
     * 获取N位随机数
     * @param len 位数
     * @return 随机数字符串
     */
    public static String getRandom(int len) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }

    /**
     * 生成去掉横线的UUID,长度32位
     * @return ce4c8b2360f64530beca44bbac46ccb2
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("\\-", "");
    }

    /**
     * 生成随机的字符串,有可能重复
     * @param length 字符串长度
     */
    public static String getRandomStr(int length) {
        return RandomStringGenerator.getNewString(length);
    }

    /**
     * 判断字符串是否JSON格式
     * @param str 要判断的字符串
     */
    public static boolean isJson(String str) {
        if(!str.startsWith("{") || !str.startsWith("[")) {
            return false;
        }
        try {
            SpringUtils.getBean(ObjectMapper.class).readTree(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 把对象序列化为JSON
     * @param object 传入对象
     * @return JSON字符串
     */
    public static String toJson(Object object) {
        try {
            return SpringUtils.getBean(ObjectMapper.class).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把对象序列化为JSON
     * @param object 传入对象
     * @return JSON字符串 忽略异常
     */
    public static String toJsonNoException(Object object) {
        try {
            return SpringUtils.getBean(ObjectMapper.class).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    /**
     * 把JSON字符串转为Map对象
     * @param json 传入JSON字符串
     * @return map对象
     */
    public static Map<String, Object> jsonToMap(String json) {
        try {
            return SpringUtils.getBean(ObjectMapper.class).readValue(json, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取客户端IP地址
     * @param request
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        return ip;
    }

    public static int getCRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        return CRC;
    }

    public static void main(String[] agrs) throws Exception {
    }
}
