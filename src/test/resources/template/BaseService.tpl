package ${baseServicePackage};

import ${domainPackage}.${sn};
import ${domainPackage}.${sn}Example;

import ${mapperPackage}.${sn}Mapper;
import com.framework.core.mybatis.PageBounds;
import com.framework.core.mybatis.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
public class Base${sn}Service {

    @Autowired
    protected ${sn}Mapper mapper;

    public long countByExample(${sn}Example example) {
        return mapper.countByExample(example);
    }

    public int deleteByExample(${sn}Example example) {
        return mapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(${sn} record) {
        return mapper.insert(record);
    }

    public int insertSelective(${sn} record) {
        return mapper.insertSelective(record);
    }

    public List<${sn}> selectPage(PageBounds page, Map<String, Object> params) {
        return mapper.selectPage(page, params);
    }

    public PageModel selectPageModel(PageBounds page, Map<String, Object> params) {
        List<${sn}> list = mapper.selectPage(page, params);
        return new PageModel(list, page);
    }

    public List<${sn}> selectByExample(${sn}Example example) {
        return mapper.selectByExample(example);
    }

    public ${sn} selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") ${sn} record, @Param("example") ${sn}Example example) {
        return mapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") ${sn} record, @Param("example") ${sn}Example example) {
        return mapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(${sn} record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(${sn} record) {
        return mapper.updateByPrimaryKey(record);
    }

}
