package com.example.tutorial.auth.service;

import com.example.tutorial.auth.controller.dto.AuthRequest;
import com.example.tutorial.auth.controller.dto.AuthResponse;
import com.example.tutorial.shared.jwt.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtTokenProvider jwtTokenUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthService(JwtTokenProvider jwtTokenUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public AuthResponse auth(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());

        authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);

        return new AuthResponse(jwtTokenUtil.generate(authRequest.getEmail()));
    }
}
