/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.maintain.notification.entity;

/**
 * 触发的子系统
 * <p>User: 
 * <p>Date: 13-7-8 下午2:19
 * <p>Version: 1.0
 */
public enum NotificationSystem {

    system("系统"), excel("excel");

    private final String info;

    private NotificationSystem(final String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}
