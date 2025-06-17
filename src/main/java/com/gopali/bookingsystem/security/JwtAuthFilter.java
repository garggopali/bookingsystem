package com.gopali.bookingsystem.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.lang.Collections;

import java.io.IOException;
import java.util.Set;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

private static final String HARDCODED_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
    "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0." +
    "KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";

@Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

    String path = request.getRequestURI();
    String method = request.getMethod();

    // Only enforce auth on secured POST endpoints
    if (requiresAuth(path, method)) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.equals(HARDCODED_TOKEN)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Missing or invalid token");
            return;
        }

        // Mark request as authenticated
        UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken("hardcoded-user", null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    filterChain.doFilter(request, response);
}

private boolean requiresAuth(String path, String method) {
    if (!method.equals("POST")) return false;
    return path.equals("/bookings") ||
           path.startsWith("/coworkers");
}

}
