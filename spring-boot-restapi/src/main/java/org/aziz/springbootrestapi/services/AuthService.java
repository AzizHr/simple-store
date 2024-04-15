package org.aziz.springbootrestapi.services;

import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
