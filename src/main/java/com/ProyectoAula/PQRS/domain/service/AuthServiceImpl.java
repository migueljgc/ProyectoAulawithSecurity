package com.ProyectoAula.PQRS.domain.service;

import com.ProyectoAula.PQRS.controller.models.AuthResponse;
import com.ProyectoAula.PQRS.controller.models.AuthenticationRequest;
import com.ProyectoAula.PQRS.controller.models.RegisterRequest;
import com.ProyectoAula.PQRS.domain.dto.UserDTO;
import com.ProyectoAula.PQRS.persistence.entity.Role;
import com.ProyectoAula.PQRS.persistence.entity.User;
import com.ProyectoAula.PQRS.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .user(request.getUser())
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .stateUser(request.getStateUser())
                .identificationType(request.getIdentificationType())
                .identificationNumber(request.getIdentificationNumber())
                .personType(request.getPersonType())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.genereteToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUser(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByEmail(request.getUser()).orElseThrow();
        var jwtToken = jwtService.genereteToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }
}
