package com.framework.code.service;

import com.framework.code.domain.LsShebJiaoy;
import com.framework.code.domain.LsShebJiaoyExample;
import com.framework.config.AppConfig;
import com.framework.core.mybatis.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LsShebJiaoyService extends BaseService<LsShebJiaoy, LsShebJiaoyExample> {

    public void insertOrUpdate(LsShebJiaoy record) {
        if(record.getId() != null) {
            updateByPrimaryKeySelective(record);
        } else {
            record.setId(AppConfig.idGenerator.nextId());
            insert(record);
        }
    }

}
