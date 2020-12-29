package com.framework.core.mybatis.base;

import com.framework.core.mybatis.PageBounds;
import com.framework.core.mybatis.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class BaseService<T, E> {

    @Autowired
    protected BaseMapper<T, E> baseMapper;

    public long countByExample(E example) {
        return baseMapper.countByExample(example);
    }

    public int deleteByExample(E example) {
        return baseMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Object id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    public int insert(T record) {
        return baseMapper.insert(record);
    }

    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    public List<T> selectPage(PageBounds page, Map<String, Object> params) {
        return baseMapper.selectPage(page, params);
    }

    public PageModel<T> selectPageModel(PageBounds page, Map<String, Object> params) {
        List<T> list = baseMapper.selectPage(page, params);
        return new PageModel<T>(list, page);
    }

    public List<T> selectByExample(E example) {
        return baseMapper.selectByExample(example);
    }

    public T selectOneByExample(E example) {
        List<T> results = baseMapper.selectByExample(example);
        return results.isEmpty() ? null : results.get(0);
    }

    public T selectByPrimaryKey(Object id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") T record, @Param("example") E example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") T record, @Param("example") E example) {
        return baseMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}
