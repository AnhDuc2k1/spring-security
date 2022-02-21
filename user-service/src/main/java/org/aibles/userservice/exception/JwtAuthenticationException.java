package org.aibles.userservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AbstractException {
    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg,httpStatus);
    }
}