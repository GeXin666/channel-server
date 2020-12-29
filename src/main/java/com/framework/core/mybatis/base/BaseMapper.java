package com.framework.core.mybatis.base;

import com.framework.core.mybatis.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T, E> {
    //根据条件查询总数
    long countByExample(E example);

    //根据条件删除
    int deleteByExample(E example);

    //根据主键删除
    int deleteByPrimaryKey(Object id);

    //插入数据(字段为NULL的则插入null)
    int insert(T record);

    //插入数据(字段为null的不插入)
    int insertSelective(T record);

    //条件分页查询
    List<T> selectPage(PageBounds page, Map<String, Object> params);

    //根据条件查询不分页
    List<T> selectByExample(E example);

    //根据主键查询
    T selectByPrimaryKey(Object id);

    //根据条件更新(属性为null不更新)
    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    //根据条件更新(属性为null更新为null)
    int updateByExample(@Param("record") T record, @Param("example") E example);

    //根据主键更新(属性为null不更新)
    int updateByPrimaryKeySelective(T record);

    //根据主键更新(属性为null更新为null)
    int updateByPrimaryKey(T record);
}
