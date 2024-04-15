package org.aziz.springbootrestapi.services.impl;

import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;
import org.aziz.springbootrestapi.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        return null;
    }
}
