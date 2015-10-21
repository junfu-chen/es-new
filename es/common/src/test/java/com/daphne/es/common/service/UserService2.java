/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.common.service;

import com.daphne.es.common.entity.User;
import com.daphne.es.common.repository.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * <p>User: 
 * <p>Date: 13-1-17 下午7:52
 * <p>Version: 1.0
 */
@DependsOn("userRepository2")
@Service()
public class UserService2 extends UserService {

    @Autowired
    @Qualifier("userRepository2")
    @Override
    public void setBaseRepository(BaseRepository<User, Long> baseRepository) {
        super.setBaseRepository(baseRepository);
    }
}
