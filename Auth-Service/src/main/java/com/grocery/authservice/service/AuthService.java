package com.grocery.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.authservice.dto.LoginRequest;
import com.grocery.authservice.dto.RegisterRequest;
import com.grocery.authservice.entity.User;
import com.grocery.authservice.jwt.JwtUtil;
import com.grocery.authservice.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    // Register new user
    public User register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return repo.save(user);
    }

    // Login and generate JWT token
    public String login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return "User Not Found";
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid Password";
        }

        // Generate JWT Token
        return jwtUtil.generateToken(user.getEmail());
    }
}