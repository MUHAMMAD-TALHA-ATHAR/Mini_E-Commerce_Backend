package com.java.projects.miniecommercebackend.service;

import com.java.projects.miniecommercebackend.dto.auth.AuthResponse;
import com.java.projects.miniecommercebackend.dto.auth.LoginRequest;
import com.java.projects.miniecommercebackend.dto.auth.RegisterRequest;
import com.java.projects.miniecommercebackend.entity.User;
import com.java.projects.miniecommercebackend.exception.BadRequestException;
import com.java.projects.miniecommercebackend.exception.UnauthorizedException;
import com.java.projects.miniecommercebackend.repository.UserRepository;
import com.java.projects.miniecommercebackend.mapper.AuthMapper;
import com.java.projects.miniecommercebackend.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, AuthMapper authMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Register a new user
    @Transactional
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("User with email " + request.getEmail() + " already exists");
        }

        User user = authMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(savedUser);

        return authMapper.toAuthResponse(savedUser, token);
    }

    // Login user and return JWT token
    @Transactional
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid email or password"));

        String token = jwtService.generateToken(user);

        return authMapper.toAuthResponse(user, token);
    }
}
