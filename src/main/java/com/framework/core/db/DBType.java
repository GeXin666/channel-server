package com.framework.core.db;

public enum DBType {

    Master("Master"),
    Slave("Slave");

    private final String value;

    DBType(String  value) {
        this.value = value;
    }

    public String  value() {
        return this.value;
    }
}
