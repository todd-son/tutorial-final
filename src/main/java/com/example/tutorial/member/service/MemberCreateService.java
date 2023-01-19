package com.example.tutorial.member.service;

import com.example.tutorial.member.controller.dto.MemberRequest;
import com.example.tutorial.member.controller.dto.MemberResponse;
import com.example.tutorial.member.exception.EmailShouldBeNotNullException;
import com.example.tutorial.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberCreateService {
    private final MemberRepository memberRepository;
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public MemberCreateService(MemberRepository memberRepository, UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public MemberResponse create(MemberRequest request) {
        if (request.getEmail() == null)
            throw new EmailShouldBeNotNullException();

        memberRepository.save(request.toModel());

        UserDetails userDetails = User.builder().username(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles("USER")
                .build();

        userDetailsManager.createUser(userDetails);

        return new MemberResponse(request.getEmail(), request.getPassword());
    }
}
