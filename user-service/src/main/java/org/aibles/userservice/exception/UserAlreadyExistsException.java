package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends AbstractException{
    public UserAlreadyExistsException() {
        super("User Already Exists", HttpStatus.CONFLICT);
    }
}