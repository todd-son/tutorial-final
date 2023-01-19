package com.example.tutorial.auth.controller;

import com.example.tutorial.auth.controller.dto.AuthRequest;
import com.example.tutorial.auth.controller.dto.AuthResponse;
import com.example.tutorial.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public AuthResponse auth(@RequestBody AuthRequest authRequest)  {
        return authService.auth(authRequest);
    }
}
