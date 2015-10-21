/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.personal.message.exception;

import com.daphne.es.common.exception.BaseException;

/**
 * <p>User: 
 * <p>Date: 13-5-24 上午7:22
 * <p>Version: 1.0
 */
public class MessageException extends BaseException {

    public MessageException(String code, Object[] args) {
        super("personal", code, args);
    }
}
