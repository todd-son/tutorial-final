package com.example.tutorial.shared.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private String jwtSecret;
    private Key key;

    public JwtTokenProvider(@Value("${jwt.secret}") String jwtSecret) {
        this.jwtSecret = jwtSecret;
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generate(String id) {
        long now = (new Date()).getTime();

        return Jwts.builder().setSubject(id)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(new Date(now + 60 * 60 * 1000))
                .compact();
    }

    public boolean validate(String token) {
        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return true;
    }

    public String parseId(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
