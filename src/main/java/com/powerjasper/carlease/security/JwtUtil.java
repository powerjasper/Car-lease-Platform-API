package com.powerjasper.carlease.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtil {
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private int expiration;

  private SecretKey key;

  /**
   * Adds broker or leaser role to the user claims if the correct username is used, otherwise assign
   * no roles. Done this way since there is no actual iam connection
   *
   * @param username the user for which to find claims
   * @return Claims assigned to the give username
   */
  private static Map<String, Object> getUserClaims(String username) {
    Map<String, Object> claims = new HashMap<>();
    if (Objects.equals(username, "broker")) {
      claims.put("Roles", List.of("ROLE_BROKER"));
    } else if (Objects.equals(username, "leaser")) {
      claims.put("Roles", List.of("ROLE_LEASER"));
    } else {
      claims.put("Roles", Collections.EMPTY_LIST);
    }
    return claims;
  }

  @PostConstruct
  public void init() {
    this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .addClaims(getUserClaims(username))
        .setExpiration(new Date((new Date()).getTime() + expiration))
        .signWith(key)
        .compact();
  }

  public String getUserFromToken(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
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
