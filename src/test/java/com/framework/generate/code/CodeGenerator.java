package com.framework.generate.code;

import com.framework.code.domain.JcSheb;
import com.framework.code.domain.JcShebZhuangt;
import com.framework.code.domain.LsShebJiaoy;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成工具
 * 可以生成Service和Controller的代码
 */
public class CodeGenerator {
    public static void main(String[] args) throws Exception {

        //改成要生成的实体类
        createCode(LsShebJiaoy.class);
    }

    public static void createCode(Class<?> clazz) throws Exception {
        System.out.println("准备生成Service BaseService Controller代码...");

        String domainPackage = clazz.getPackage().getName();
        String mapperPackage = domainPackage.replaceAll("domain", "mapper");
        String servicePackage = domainPackage.replaceAll("domain", "service");
        String controllerPackage = domainPackage.replaceAll("domain", "controller");

        System.out.println("domainPackage =" + domainPackage);
        System.out.println("mapperPackage =" + mapperPackage);
        System.out.println("servicePackage = " + servicePackage);
        System.out.println("controllerPackage = " + controllerPackage);

        createMapper(clazz, domainPackage, mapperPackage);
        createService(clazz, domainPackage, mapperPackage, servicePackage);
        createController(clazz, domainPackage, mapperPackage, servicePackage, controllerPackage);

        System.out.println("生成Service BaseService Controller代码完毕...");
    }

    /**
     * 获取FM模板
     */
    public static Template getTemplate(String name) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File(
                System.getProperty("user.dir") + "/src/test/resources/template/"));
        Template template = cfg.getTemplate(name);
        return template;
    }

    /**
     * 生成Mapper.java
     */
    public static void createMapper(Class<?> clazz, String domainPackage, String mapperPackage) throws Exception {
        String sn = clazz.getSimpleName();
        String camel = sn.substring(0,1).toLowerCase()+sn.substring(1);
        Template template = getTemplate("Mapper.tpl");
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("domainPackage", domainPackage);
        root.put("mapperPackage", mapperPackage);
        root.put("sn", sn);
        root.put("camel", camel);
        File codeDir = new File(System.getProperty("user.dir") + "/src/test/java/" +
                mapperPackage.replaceAll("\\.", "/"));
        codeDir.mkdirs();
        FileWriter fileWriter = new FileWriter(new File(codeDir, sn+"Mapper.java"));
        template.process(root, fileWriter);
    }

    /**
     * 生成Service.java
     */
    public static void createService(Class<?> clazz, String domainPackage,
                                     String mapperPackage, String servicePackage) throws Exception {
        String sn = clazz.getSimpleName();
        String camel = sn.substring(0,1).toLowerCase()+sn.substring(1);
        Template template = getTemplate("Service.tpl");
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("domainPackage", domainPackage);
        root.put("mapperPackage", mapperPackage);
        root.put("servicePackage", servicePackage);
        root.put("sn", sn);
        root.put("camel", camel);
        File codeDir = new File(System.getProperty("user.dir") + "/src/test/java/" +
                servicePackage.replaceAll("\\.", "/"));
        codeDir.mkdirs();
        FileWriter fileWriter = new FileWriter(new File(codeDir,sn+"Service.java"));
        template.process(root, fileWriter);
    }

    /**
     * 生成Controller.java
     */
    public static void createController(Class<?> clazz, String domainPackage,
                                        String mapperPackage, String servicePackage,
                                        String controllerPackage) throws Exception {
        String sn = clazz.getSimpleName();
        String camel = sn.substring(0,1).toLowerCase()+sn.substring(1);
        Template template = getTemplate("Controller.tpl");
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("domainPackage", domainPackage);
        root.put("mapperPackage", mapperPackage);
        root.put("servicePackage", servicePackage);
        root.put("controllerPackage", controllerPackage);
        root.put("sn", sn);
        root.put("camel", camel);
        File codeDir = new File(System.getProperty("user.dir") + "/src/test/java/" +
                controllerPackage.replaceAll("\\.", "/"));
        codeDir.mkdirs();
        FileWriter fileWriter = new FileWriter(new File(codeDir,sn+"Controller.java"));
        template.process(root, fileWriter);
    }
}
