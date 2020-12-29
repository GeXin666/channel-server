package com.framework.code.service;

import com.framework.code.domain.JcShebZhuangt;
import com.framework.code.domain.JcShebZhuangtExample;
import com.framework.config.AppConfig;
import com.framework.core.mybatis.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JcShebZhuangtService extends BaseService<JcShebZhuangt, JcShebZhuangtExample> {

    public void insertOrUpdate(JcShebZhuangt record) {
        if(record.getId() != null) {
            updateByPrimaryKeySelective(record);
        } else {
            record.setId(AppConfig.idGenerator.nextId());
            insert(record);
        }
    }

}
