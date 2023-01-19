package com.example.tutorial.hello.controller;

import com.example.tutorial.shared.jwt.JwtTokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {
    private final JwtTokenProvider jwtTokenUtil;

    private final UserDetailsManager userDetailsManager;

    public HelloController(JwtTokenProvider jwtTokenUtil, UserDetailsManager userDetailsManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsManager = userDetailsManager;
    }

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi world!";
    }
}
