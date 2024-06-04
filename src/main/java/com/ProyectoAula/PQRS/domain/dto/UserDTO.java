package com.ProyectoAula.PQRS.domain.dto;


import com.ProyectoAula.PQRS.persistence.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigInteger;


@Data
public class UserDTO {
    private String user;
    private String password;
    private Role role;
    private String stateUser;
    private PersonType personType;
    private String name;
    private String lastName;
    private String email;
    private IdentificationType identificationType;
    private BigInteger identificationNumber;
}
