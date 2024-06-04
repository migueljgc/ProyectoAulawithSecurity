package com.ProyectoAula.PQRS.domain.mapper;

import com.ProyectoAula.PQRS.domain.dto.*;
import com.ProyectoAula.PQRS.persistence.entity.*;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUser(userDTO.getUser());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setStateUser(userDTO.getStateUser());
        return user;
    }

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user.getUser());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setStateUser(user.getStateUser());
        return userDTO;
    }

}
