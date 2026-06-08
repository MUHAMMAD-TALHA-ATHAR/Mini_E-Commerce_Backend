package com.java.projects.miniecommercebackend.dto.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between {min} and {max} characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Size(max = 40, message = "Email cannot exceed {max} characters")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least {min} characters long")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Size(max = 11, message = "Phone number cannot exceed {max} characters")
    @Pattern(regexp = "^[0-9]{11}$", message = "Phone number must contain exactly 11 digits")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;
}
