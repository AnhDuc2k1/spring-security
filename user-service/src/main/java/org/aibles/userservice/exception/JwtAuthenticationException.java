package org.aibles.userservice.exception;

import org.springframework.http.HttpStatus;

public class JwtAuthenticationException extends AbstractException{
    public JwtAuthenticationException(){
        super("Jwt is invalid or expired", HttpStatus.UNAUTHORIZED);
    }
}
