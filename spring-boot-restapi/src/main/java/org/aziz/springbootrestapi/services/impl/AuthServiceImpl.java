package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;
import org.aziz.springbootrestapi.exceptions.UsernameNotFoundException;
import org.aziz.springbootrestapi.models.User;
import org.aziz.springbootrestapi.repositories.UserRepository;
import org.aziz.springbootrestapi.security.Authenticator;
import org.aziz.springbootrestapi.security.JwtService;
import org.aziz.springbootrestapi.services.AuthService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        Authenticator authenticator = new Authenticator(user);
        String jwtToken = jwtService.generateToken(authenticator);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtToken);
        return authResponse;
    }
}
