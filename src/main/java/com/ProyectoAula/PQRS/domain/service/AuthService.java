package com.ProyectoAula.PQRS.domain.service;

import com.ProyectoAula.PQRS.controller.models.AuthResponse;
import com.ProyectoAula.PQRS.controller.models.AuthenticationRequest;
import com.ProyectoAula.PQRS.controller.models.RegisterRequest;
import org.springframework.stereotype.Service;


public interface AuthService {
    AuthResponse register (RegisterRequest Request );
    AuthResponse authenticate (AuthenticationRequest Request );

}
