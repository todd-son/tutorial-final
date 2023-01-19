package com.example.tutorial.member.controller;

import com.example.tutorial.member.controller.dto.MemberRequest;
import com.example.tutorial.member.controller.dto.MemberResponse;
import com.example.tutorial.member.service.MemberCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberCreateService memberCreateService;

    public MemberController(MemberCreateService memberCreateService) {
        this.memberCreateService = memberCreateService;
    }

    @PostMapping("/member")
    public MemberResponse create(@RequestBody MemberRequest request) {
        return memberCreateService.create(request);
    }
}
