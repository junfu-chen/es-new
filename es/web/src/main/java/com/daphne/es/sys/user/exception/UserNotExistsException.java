/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.es.sys.user.exception;


/**
 * <p>User: 
 * <p>Date: 13-3-11 下午8:28
 * <p>Version: 1.0
 */
public class UserNotExistsException extends UserException {

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
