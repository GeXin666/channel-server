package com.framework.config;

import com.framework.core.uitls.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfig {

    /**
     * 机房标识(1-31)
     */
    public static int datacenter;

    @Value("${app.config.id.generate.datacenter}")
    public void setDatacenter(int datacenter) {
        AppConfig.datacenter = datacenter;
    }

    /**
     * 机器标识(1-31)
     */
    private static int worker;

    @Value("${app.config.id.generate.worker}")
    public void setWorker(int worker) {
        this.worker = worker;
    }

    /**
     * 最大上传文件大小MB
     */
    public static long maxUploadSize;

    @Value("${app.config.file.max.upload.size}")
    public void setMaxUploadSize(long maxUploadSize) {
        AppConfig.maxUploadSize = maxUploadSize;
    }

    /**
     * 上传文件保存路径
     */
    public static String uploadTempDir;

    @Value("${app.config.file.upload.temp.dir}")
    public void setUploadTempDir(String uploadTempDir) {
        AppConfig.uploadTempDir = uploadTempDir;
    }

    /**
     * 上传文件在内存中的阀值byte
     */
    public static int maxInMemorySize;

    @Value("${app.config.file.max.memory.size}")
    public void setMaxInMemorySize(int maxInMemorySize) {
        AppConfig.maxInMemorySize = maxInMemorySize;
    }

    /**
     * EventBus名称
     */
    public static String eventBusName;

    @Value("${app.config.eventbus.name}")
    public void setEventBusName(String eventBusName) {
        AppConfig.eventBusName = eventBusName;
    }

    /**
     * Netty服务器端口
     */
    public static int serverPort;
    @Value("${app.config.netty.server.port}")
    public void setServerPort(int serverPort) {
        AppConfig.serverPort = serverPort;
    }

    /**
     * EventBus线程数
     */
    public static int eventBusThreadCount;

    @Value("${app.config.eventbus.thread}")
    public void setEventBusThreadCount(int eventBusThreadCount) {
        AppConfig.eventBusThreadCount = eventBusThreadCount;
    }

    /**
     * Long类型时间序列递增的ID生成器
     */
    public static SequenceIdGenerator idGenerator = null;

    /**
     * Long类型时间序列递增的ID生成器
     * 分布式情况下datacenter和worker不能重复
     */
    @Bean
    public SequenceIdGenerator sequenceIdGenerator() {
        idGenerator = new SequenceIdGenerator(datacenter, worker);
        return idGenerator;
    }

    /**
     * 获取jar包跟目录
     * 比如jar在/home/springboot/myapp.jar
     * 则返回/home/springboot
     */
    public static String getRootPath() {
        ApplicationHome home = new ApplicationHome();
        return home.getDir().getAbsolutePath();
    }

    /**
     * 获取jar包跟目录
     * 比如jar在/home/springboot/myapp.jar
     * 则返回/home/springboot
     */
    public static File getRootDir() {
        ApplicationHome home = new ApplicationHome();
        return home.getDir();
    }
}
