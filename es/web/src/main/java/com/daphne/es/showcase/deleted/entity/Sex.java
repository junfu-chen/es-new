/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.showcase.deleted.entity;

/**
 * <p>User: 
 * <p>Date: 13-2-4 下午2:48
 * <p>Version: 1.0
 */
public enum Sex {
    male("男"), female("女");

    private final String info;

    private Sex(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
