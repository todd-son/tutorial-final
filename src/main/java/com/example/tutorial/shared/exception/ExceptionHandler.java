package com.example.tutorial.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(DomainException.class)
    public ResponseEntity<ExceptionMessage> handle(Throwable throwable) {
            return new ResponseEntity(
                    new ExceptionMessage(throwable.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionMessage> handleUnexpectedException(Throwable throwable) {
//        return new ResponseEntity(
//                new ExceptionMessage(throwable.getMessage()),
//                HttpStatus.INTERNAL_SERVER_ERROR
//        );
//    }
}
