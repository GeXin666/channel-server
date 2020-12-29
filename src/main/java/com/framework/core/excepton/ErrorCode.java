package com.framework.core.excepton;

import java.util.HashMap;
import java.util.Map;

public final class ErrorCode {

    private static final Map<String, String> errorMsg = new HashMap<>();

    public static final String CODE_00000 = "00000";
    public static final String CODE_00001 = "00001";
    public static final String CODE_00002 = "00002";
    public static final String CODE_00003 = "00003";
    public static final String CODE_00004 = "00004";
    public static final String CODE_00005 = "00005";
    public static final String CODE_00006 = "00006";
    public static final String CODE_00007 = "00007";
    public static final String CODE_00008 = "00008";
    public static final String CODE_00009 = "00009";
    public static final String CODE_00010 = "00010";

    static {
        errorMsg.put(CODE_00000, "系统故障");
        errorMsg.put(CODE_00001, "系统错误");
        errorMsg.put(CODE_00002, "业务错误");
        errorMsg.put(CODE_00003, "权限不足[没有所需账户]");
        errorMsg.put(CODE_00004, "权限不足[没有所需角色]");
        errorMsg.put(CODE_00005, "权限不足[没有所需权限]");
        errorMsg.put(CODE_00006, "权限不足[没有登录]");
        errorMsg.put(CODE_00007, "发现SQL注入参数");
        errorMsg.put(CODE_00008, "找不到数据库分片的KEY");
        errorMsg.put(CODE_00009, "数据库分库的数量必须是2的倍数");
        errorMsg.put(CODE_00010, "接口访问超时");
    }

    public static String getErrorMsg(String code) {
        String msg = errorMsg.get(code);
        return  msg != null ? msg : code;
    }
}
