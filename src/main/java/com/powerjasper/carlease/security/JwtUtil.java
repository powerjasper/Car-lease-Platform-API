package com.powerjasper.carlease.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        if (Objects.equals(username, "jasper")) {
            claims.put("Roles", List.of("ROLE_CUSTOMERS"));
        } else {
            claims.put("Roles", Collections.EMPTY_LIST);
        }

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .addClaims(claims)
                .setExpiration(new Date((new Date()).getTime() + expiration))
                .signWith(key)
                .compact();
    }

    public String getUserFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> getRolesFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("Roles", List.class);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error("Invalid token ", e);
        }
        return false;
    }
}
