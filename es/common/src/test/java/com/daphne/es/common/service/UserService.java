/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.common.service;

import com.daphne.es.common.entity.User;
import com.daphne.es.common.repository.BaseRepository;
import com.daphne.es.common.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * <p>User: 
 * <p>Date: 13-1-17 下午7:52
 * <p>Version: 1.0
 */
@DependsOn("userRepository")
@Service()
public class UserService extends BaseService<User, Long> {

    @Autowired
    @Qualifier("userRepository")
    @Override
    public void setBaseRepository(BaseRepository<User, Long> baseRepository) {
        super.setBaseRepository(baseRepository);
    }
}
