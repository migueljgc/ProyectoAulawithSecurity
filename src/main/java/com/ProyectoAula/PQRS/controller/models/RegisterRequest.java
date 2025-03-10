package com.ProyectoAula.PQRS.controller.models;


import com.ProyectoAula.PQRS.persistence.entity.IdentificationType;
import com.ProyectoAula.PQRS.persistence.entity.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String user;
    private String password;
    private PersonType personType;
    private String name;
    private String lastName;
    private String email;
    private IdentificationType identificationType;
    private BigInteger identificationNumber;
    private String stateUser;

}
