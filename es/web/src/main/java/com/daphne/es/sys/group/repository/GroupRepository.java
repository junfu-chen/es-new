/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.sys.group.repository;

import com.daphne.es.common.repository.BaseRepository;
import com.daphne.es.sys.group.entity.Group;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>User: 
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface GroupRepository extends BaseRepository<Group, Long> {

    @Query("select id from Group where defaultGroup=true and show=true")
    List<Long> findDefaultGroupIds();

}
