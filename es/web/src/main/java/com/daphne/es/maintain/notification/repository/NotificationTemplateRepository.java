/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.maintain.notification.repository;

import com.daphne.es.common.repository.BaseRepository;
import com.daphne.es.maintain.notification.entity.NotificationTemplate;

import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: 
 * <p>Date: 13-5-22 下午2:39
 * <p>Version: 1.0
 */
public interface NotificationTemplateRepository extends BaseRepository<NotificationTemplate, Long> {

    @Query("from NotificationTemplate o where name=?1")
    NotificationTemplate findByName(String name);
}
