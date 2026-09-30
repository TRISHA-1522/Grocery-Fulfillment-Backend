package com.grocery.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.grocery.authservice.dto.LoginRequest;
import com.grocery.authservice.dto.RegisterRequest;
import com.grocery.authservice.entity.User;
import com.grocery.authservice.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5176")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){
        return service.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return service.login(request);
    }
}