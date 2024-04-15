package org.aziz.springbootrestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.aziz.springbootrestapi.dtos.request.AuthRequest;
import org.aziz.springbootrestapi.dtos.request.RegisterRequest;
import org.aziz.springbootrestapi.dtos.response.AuthResponse;
import org.aziz.springbootrestapi.dtos.response.RegisterResponse;
import org.aziz.springbootrestapi.exceptions.EmailAlreadyInUseException;
import org.aziz.springbootrestapi.exceptions.UsernameNotFoundException;
import org.aziz.springbootrestapi.models.Address;
import org.aziz.springbootrestapi.models.User;
import org.aziz.springbootrestapi.repositories.AddressRepository;
import org.aziz.springbootrestapi.repositories.UserRepository;
import org.aziz.springbootrestapi.security.Authenticator;
import org.aziz.springbootrestapi.security.JwtService;
import org.aziz.springbootrestapi.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws EmailAlreadyInUseException {
        if(userRepository.findUserByEmail(registerRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyInUseException();
        } else {
            User user = modelMapper.map(registerRequest, User.class);
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            User registeredUser = userRepository.save(user);
            Address address = registerRequest.getAddress();
            address.setUser(registeredUser);
            addressRepository.save(address);
            return modelMapper.map(user, RegisterResponse.class);
        }
    }
}
