package com.example.tutorial.member.controller.dto;

import com.example.tutorial.member.model.Member;

public class MemberRequest {
    private String name;

    private String email;
    private String password;

    public MemberRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Member toModel() {
        return Member.of(name, email);
    }
}
