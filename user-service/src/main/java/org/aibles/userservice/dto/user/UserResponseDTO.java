package org.aibles.userservice.dto.user;

import lombok.Data;

@Data
public class UserResponseDTO {

    private int id;
    private String name;
    private int age;
    private String email;

}
