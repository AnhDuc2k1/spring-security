package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class LoginException extends AbstractException{
    public LoginException(){
        super("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }
}