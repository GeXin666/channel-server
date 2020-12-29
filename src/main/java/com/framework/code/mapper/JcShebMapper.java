package com.framework.code.mapper;

import com.framework.code.domain.JcSheb;
import com.framework.code.domain.JcShebExample;
import com.framework.core.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface JcShebMapper extends BaseMapper<JcSheb, JcShebExample> {

    /**
     * 查询设备ID
     * @param ip 客户端IP地址
     * @param port 客户端端口号
     * @return 设备ID
     */
    Long queryDeviceId(@Param("ip") String ip, @Param("port") int port);
}