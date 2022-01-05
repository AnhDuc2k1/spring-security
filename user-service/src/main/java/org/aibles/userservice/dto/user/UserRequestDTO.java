package org.aibles.userservice.dto.user;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRequestDTO {

    @NotBlank(message = "Name must not be blank")
    @Pattern(regexp = "[^0-9]+", message = "Name cannot contain numbers")
    @Size(min = 1, max =30, message = "Name must have atleast 1 characters")
    private String name;

    @Min(value = 18, message = "Age must be more than 18")
    private int age;

    @NotBlank(message = "Email must not be null")
    private String email;

    @NotBlank(message = "Account must not be null")
    private String account;

    @NotBlank(message = "Password must not be null")
    private String password;
}
