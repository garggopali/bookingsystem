package com.gopali.bookingsystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("gopali".equals(username)) {
            return User.withUsername("gopali")
                    .password("{noop}password") // {noop} indicates no password encoding
                    .roles("USER")
                    .build();
        } else if("ashu".equals(username)) {
            return User.withUsername("ashu")
                    .password("{noop}password") // {noop} indicates no password encoding
                    .roles("ADMIN")
                    .build();}
        else {
            throw new UsernameNotFoundException("User  not found");
        }
    }    
}
