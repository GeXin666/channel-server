package com.framework.code.service;

import com.framework.code.domain.JcSheb;
import com.framework.code.domain.JcShebExample;
import com.framework.code.domain.JcShebZhuangt;
import com.framework.code.domain.LsShebJiaoy;
import com.framework.code.mapper.JcShebMapper;
import com.framework.config.AppConfig;
import com.framework.core.mybatis.base.BaseService;
import com.framework.netty.message.ProtocolMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional
public class JcShebService extends BaseService<JcSheb, JcShebExample> {

    @Autowired
    private LsShebJiaoyService lsShebJiaoyService;

    @Autowired
    private JcShebZhuangtService jcShebZhuangtService;

    public void insertOrUpdate(JcSheb record) {
        if(record.getId() != null) {
            updateByPrimaryKeySelective(record);
        } else {
            record.setId(AppConfig.idGenerator.nextId());
            insert(record);
        }
    }

    /**
     * 处理报文
     * 设备id根据ip+port从设备表视图(v_jc_sheb)查询
     * 新增ls_sheb_jiaoy设备交易流水表
     * 更新jc_sheb_zhuangt设备状态表
     * @param msg 解码后的报文
     */
    public void processProtocolMsg(ProtocolMsg msg) {
        Long deivceId = this.queryDeviceId(msg.getIp(), msg.getPort());
        if(deivceId == null || deivceId.longValue() == 0) {
            log.warn("设备ID不存在.请初始化基础数据 ip:{} port:{}", msg.getIp(), msg.getPort());
            return;
        }

        //新增交易流水
        LsShebJiaoy jiaoy = new LsShebJiaoy();
        jiaoy.setId(AppConfig.idGenerator.nextId());
        jiaoy.setIp(msg.getIp());
        jiaoy.setJiaoysj((int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        jiaoy.setDuank(msg.getPort());
        jiaoy.setShebid(deivceId);
        jiaoy.setCansbbid(msg.getCsbb());
        jiaoy.setWenkzt1((int) msg.getWenkzt1());
        jiaoy.setWenkzt2((int) msg.getWenkzt2());
        jiaoy.setWenkzt3((int) msg.getWenkzt3());
        jiaoy.setJiarzt1((int) msg.getJiarzt1());
        jiaoy.setJiarzt2((int) msg.getJiarzt2());
        jiaoy.setJiarzt3((int) msg.getJiarzt3());
        jiaoy.setWend1((int) msg.getWend1());
        jiaoy.setWend2((int) msg.getWend2());
        jiaoy.setWend3((int) msg.getWend3());
        jiaoy.setShid((int) msg.getShid());
        jiaoy.setGongzms((int) msg.getGongzms());
        lsShebJiaoyService.insert(jiaoy);
        log.info("新增交易流水成功.设备ID:[{}]", deivceId);

        JcShebZhuangt zhuangt = jcShebZhuangtService.queryByDeviceId(deivceId);
        if(zhuangt == null) {
            log.warn("通过设备ID:[{}] 查询不到设备状态数据.请先初始化基础数据", deivceId);
            return;
        }

        zhuangt.setCansbbid(msg.getCsbb());
        zhuangt.setWenkzt1((int) msg.getWenkzt1());
        zhuangt.setWenkzt2((int) msg.getWenkzt2());
        zhuangt.setWenkzt3((int) msg.getWenkzt3());
        zhuangt.setJiarzt1((int) msg.getJiarzt1());
        zhuangt.setJiarzt2((int) msg.getJiarzt2());
        zhuangt.setJiarzt3((int) msg.getJiarzt3());
        zhuangt.setWend1((int) msg.getWend1());
        zhuangt.setWend2((int) msg.getWend2());
        zhuangt.setWend3((int) msg.getWend3());
        zhuangt.setShid((int) msg.getShid());
        zhuangt.setGongzms((int) msg.getGongzms());
        jcShebZhuangtService.updateByPrimaryKey(zhuangt);
        log.info("更新设备状态成功.设备ID:[{}]", deivceId);
    }

    /**
     * 查询设备ID
     * @param ip 客户端IP地址
     * @param port 客户端端口号
     * @return 设备ID
     */
    public Long queryDeviceId(String ip, int port) {
        JcShebMapper mapper = (JcShebMapper) baseMapper;
        return mapper.queryDeviceId(ip, port);
    }

}

