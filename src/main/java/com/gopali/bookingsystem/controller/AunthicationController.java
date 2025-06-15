package com.gopali.bookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopali.bookingsystem.service.UserDetailsServiceImpl;
import com.gopali.bookingsystem.util.JwtUtilProvider;

@RestController
public class AunthicationController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilProvider jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // Here you would typically check the password
        if (userDetails.getPassword().equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
