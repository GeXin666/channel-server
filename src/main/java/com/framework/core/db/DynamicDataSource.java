package com.framework.core.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DBTYPE = new ThreadLocal<>();

    public static void setType(DBType type) {
        DBTYPE.set(type.value());
    }

    public static String getType() {
        return DBTYPE.get();
    }

    public static void clean() {
        DBTYPE.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String name = DynamicDataSource.getType();
        if(log.isDebugEnabled()) {
            log.debug("DynamicDataSource choose dbType is:[" + name + "]");
        }
        return name;
    }
}
