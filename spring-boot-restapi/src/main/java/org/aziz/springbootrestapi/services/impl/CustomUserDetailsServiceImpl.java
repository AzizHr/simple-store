package org.aziz.springbootrestapi.services.impl;

import org.aziz.springbootrestapi.services.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
