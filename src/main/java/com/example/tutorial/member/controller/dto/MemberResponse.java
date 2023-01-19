package com.example.tutorial.member.controller.dto;

public class MemberResponse {
    private String id;
    private String password;

    public MemberResponse(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
