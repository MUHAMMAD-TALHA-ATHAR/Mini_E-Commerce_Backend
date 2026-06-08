package com.java.projects.miniecommercebackend.mapper;

import com.java.projects.miniecommercebackend.dto.auth.AuthResponse;
import com.java.projects.miniecommercebackend.dto.auth.RegisterRequest;
import com.java.projects.miniecommercebackend.entity.User;
import com.java.projects.miniecommercebackend.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public User toEntity(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // encode in service
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole(Role.USER);
        return user;
    }

    public AuthResponse toAuthResponse(User user, String token) {

        return AuthResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .token(token)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}