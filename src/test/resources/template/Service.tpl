package ${servicePackage};

import com.framework.core.mybatis.base.BaseService;
import ${domainPackage}.${sn}Example;
import ${domainPackage}.${sn};
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.framework.config.AppConfig;

@Service
@Transactional
public class ${sn}Service extends BaseService<${sn}, ${sn}Example> {

    public void insertOrUpdate(${sn} record) {
        if(record.getId() != null) {
            updateByPrimaryKeySelective(record);
        } else {
            record.setId(AppConfig.idGenerator.nextId());
            insert(record);
        }
    }

}
