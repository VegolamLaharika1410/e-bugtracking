package com.project.bugtrackingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotAvailableException extends RuntimeException {

    public UserNotAvailableException(String message) {
        super(message);
    }
}
