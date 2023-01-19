package com.example.tutorial.member.exception;

import com.example.tutorial.shared.exception.DomainException;

public class EmailShouldBeNotNullException extends DomainException {
    public EmailShouldBeNotNullException() {
        super("이메일은 반드시 입력해야 됩니다.");
    }
}
