/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.common.entity;

/**
 * <p>学校类型</p>
 * <p>User: 
 * <p>Date: 13-1-14 下午2:15
 * <p>Version: 1.0
 */
public enum SchoolType {
    primary_school("小学"), secondary_school("中学"), high_school("高中"), university("大学");

    private final String info;

    private SchoolType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
