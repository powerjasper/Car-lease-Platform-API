package com.powerjasper.carlease.controller;

import com.powerjasper.carlease.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired
    private JwtUtil jwtUtils;

    @GetMapping("/signin/{username}")
    public String authenticateUser(@PathVariable String username) {
        return jwtUtils.generateToken(username);
    }
}
