package com.ProyectoAula.PQRS.domain.service;


import com.ProyectoAula.PQRS.domain.dto.UserDTO;
import com.ProyectoAula.PQRS.domain.mapper.UserMapper;
import com.ProyectoAula.PQRS.persistence.entity.User;
import com.ProyectoAula.PQRS.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO) {
        userRepository.save(UserMapper.toEntity(userDTO));
        return userDTO;
    }
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(String id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }



}
