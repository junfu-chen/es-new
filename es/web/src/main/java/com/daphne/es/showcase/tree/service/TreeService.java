/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.showcase.tree.service;

import com.daphne.es.common.plugin.serivce.BaseTreeableService;
import com.daphne.es.showcase.tree.entity.Tree;
import com.daphne.es.showcase.tree.repository.TreeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: 
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class TreeService extends BaseTreeableService<Tree, Long> {

}
