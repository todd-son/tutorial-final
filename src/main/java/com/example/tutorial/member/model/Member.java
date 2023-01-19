package com.example.tutorial.member.model;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Member() {

    }

    public Member(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static Member of(String name, String email) {
        return new Member(null, name, email);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
