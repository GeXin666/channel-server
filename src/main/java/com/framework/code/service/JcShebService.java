package com.framework.code.service;

import com.framework.code.domain.JcSheb;
import com.framework.code.domain.JcShebExample;
import com.framework.config.AppConfig;
import com.framework.core.mybatis.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JcShebService extends BaseService<JcSheb, JcShebExample> {

    public void insertOrUpdate(JcSheb record) {
        if(record.getId() != null) {
            updateByPrimaryKeySelective(record);
        } else {
            record.setId(AppConfig.idGenerator.nextId());
            insert(record);
        }
    }

}
