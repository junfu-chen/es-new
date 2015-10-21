/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.showcase.parentchild.service;

import com.daphne.es.common.service.BaseService;
import com.daphne.es.showcase.parentchild.entity.Child;
import com.daphne.es.showcase.parentchild.entity.Parent;
import com.daphne.es.showcase.parentchild.repository.ParentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: 
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class ParentService extends BaseService<Parent, Long> {

    @Autowired
    private ChildService childService;


    public void save(Parent parent, List<Child> childList) {
        save(parent);
        saveOrUpdateChild(parent, childList);
    }

    public void update(Parent parent, List<Child> childList) {
        update(parent);
        saveOrUpdateChild(parent, childList);
    }

    private void saveOrUpdateChild(Parent parent, List<Child> childList) {
        for (Child child : childList) {
            if (child == null) {//防止中间有跳过的
                continue;
            }
            child.setParent(parent);
            if (child.getId() == null) {//新的
                childService.save(child);
            } else {
                childService.update(child);
            }
        }
    }
}