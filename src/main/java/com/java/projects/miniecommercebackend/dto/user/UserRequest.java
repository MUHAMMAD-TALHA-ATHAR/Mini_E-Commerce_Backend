package com.java.projects.miniecommercebackend.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between {min} and {max} characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Size(max = 40, message = "Email cannot exceed {max} characters")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must contain exactly 11 digits")
    private String phone;

    private String address;

    private String password;
}