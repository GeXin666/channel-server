package com.framework.generate.mybaits;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBatisCodeGenerate {

	/**
	 * Mybatis代码生成工具
	 * 1:生成domain.java实体类
	 * 2:生成mapper.xml文件
	 * 3:生成mapper.java文件
	 * 备注:配置文件中 targetProject 指定你的代码text/java文件夹
	 * 例如我的:C:\Users\GX\IdeaProjects\easy-framework\easy-generate\src\test
	 */
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
        String genCfg = "/mybatis-generator-cfg.xml";
        File configFile = new File(MyBatisCodeGenerate.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(false);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("Mybatis 代码生成完毕......");
	}

}
