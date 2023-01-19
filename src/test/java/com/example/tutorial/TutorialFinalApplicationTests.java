package com.example.tutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootTest
class TutorialFinalApplicationTests {
    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void createAdminUser() {
        UserDetails userDetails = User.builder()
                .username("sujin")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN", "USER")
                .build();

        userDetailsManager.createUser(userDetails);
    }

