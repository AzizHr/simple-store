package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.request.RegisterRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;
import org.aziz.springbootrestapi.dtos.response.RegisterResponse;
import org.aziz.springbootrestapi.exceptions.EmailAlreadyInUseException;
import org.aziz.springbootrestapi.exceptions.UsernameNotFoundException;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest) throws UsernameNotFoundException;
    RegisterResponse register(RegisterRequest registerRequest) throws UsernameNotFoundException, EmailAlreadyInUseException;
}
