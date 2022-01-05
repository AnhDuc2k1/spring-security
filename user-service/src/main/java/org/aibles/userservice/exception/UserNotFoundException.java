package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractException{
    public UserNotFoundException() {
        super("User Not Found", HttpStatus.NOT_FOUND);
    }
}
