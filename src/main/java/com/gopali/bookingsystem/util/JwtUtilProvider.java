package com.gopali.bookingsystem.util;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtilProvider {

@Value("${app.jwt.secret}")
private String jwtSecret;

@Value("$(app.jwt.expiry)")
private String expiryInMillis;
private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String userName){
        Date todayDate=new Date();
        Date expiryDate=new Date(todayDate.getTime()+Long.parseLong(expiryInMillis));
        return Jwts.builder().setSubject(userName)
            .setIssuedAt(todayDate)
            .setExpiration(expiryDate)
            .claim("admin", true)
            .signWith(getSigningKey())
            .compact();
    }

}
