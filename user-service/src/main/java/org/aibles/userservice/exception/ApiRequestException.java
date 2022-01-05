package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends AbstractException{

    public ApiRequestException(String message, HttpStatus status) {
        super(message, status);
    }
}
