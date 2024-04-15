package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;
import org.aziz.springbootrestapi.exceptions.UsernameNotFoundException;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest) throws UsernameNotFoundException;
}
