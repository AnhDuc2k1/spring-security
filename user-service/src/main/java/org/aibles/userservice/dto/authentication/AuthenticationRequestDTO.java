package org.aibles.userservice.dto.authentication;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}