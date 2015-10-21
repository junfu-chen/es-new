/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.sys.permission.repository;

import com.daphne.es.common.repository.BaseRepository;
import com.daphne.es.sys.permission.entity.Role;
import com.daphne.es.sys.permission.entity.RoleResourcePermission;

import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: 
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface RoleRepository extends BaseRepository<Role, Long> {

    @Query("from RoleResourcePermission where role=?1 and resourceId=?2")
    RoleResourcePermission findRoleResourcePermission(Role role, Long resourceId);
}
