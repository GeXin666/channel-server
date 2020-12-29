package com.framework.generate.mybaits;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 扩展生成器
 * 添加分页查询的xml生成逻辑
 */
public class MyBatisCodePlugin extends PluginAdapter {

    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
                                                                 IntrospectedTable introspectedTable) {

        interfaze.addMethod(generateDeleteLogicByIds(method, introspectedTable));

        return true;
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
                                                                    IntrospectedTable introspectedTable) {

        interfaze.addMethod(generateDeleteLogicByIds(method, introspectedTable));

        return true;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
                                                                 IntrospectedTable introspectedTable) {

        topLevelClass.addMethod(generateDeleteLogicByIds(method, introspectedTable));
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
                                                                    IntrospectedTable introspectedTable) {

        topLevelClass.addMethod(generateDeleteLogicByIds(method, introspectedTable));
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名

        XmlElement parentElement = document.getRootElement();

        // 产生分页语句前半部分
        XmlElement selectpage = new XmlElement("select");
        selectpage.addAttribute(new Attribute("id", "selectPage"));
        selectpage.addAttribute(new Attribute("parameterType", "hashmap"));
        selectpage.addAttribute(new Attribute("resultMap", "BaseResultMap"));

        selectpage.addElement(new TextElement("SELECT <include refid=\"Base_Column_List\" /> FROM " + tableName));

        XmlElement where = new XmlElement("where");

        StringBuilder s = new StringBuilder();
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        for (IntrospectedColumn c : columns) {
            s.append("<if test=\"" + c.getJavaProperty() + " != null\"> \r\n and " + c.getActualColumnName() + " "
                    + "= #{" + c.getJavaProperty() + ",jdbcType=" + c.getJdbcTypeName() + "} \r\n </if> \r\n");
        }

        // System.out.println(s.toString());
        where.addElement(new TextElement(s.toString()));
        selectpage.addElement(where);
        parentElement.addElement(selectpage);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private Method generateDeleteLogicByIds(Method method, IntrospectedTable introspectedTable) {

        Method m = new Method("selectPage");
        m.setVisibility(method.getVisibility());
        m.setReturnType(new FullyQualifiedJavaType("List<" + introspectedTable.getBaseRecordType() + ">"));
        m.addParameter(new Parameter(new FullyQualifiedJavaType("PageBounds"), "page"));
        m.addParameter(new Parameter(new FullyQualifiedJavaType("Map<String, Object>"), "params"));

        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成实体类的set方法
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成实体类的get方法
        return false;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
        topLevelClass.addImportedType("lombok.AllArgsConstructor");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addAnnotation("@AllArgsConstructor");
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator " + date2Str(new Date()));
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }
}
