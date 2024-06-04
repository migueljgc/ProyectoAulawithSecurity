package com.ProyectoAula.PQRS.controller;


import com.ProyectoAula.PQRS.domain.common.Route;
import com.ProyectoAula.PQRS.domain.dto.UserDTO;
import com.ProyectoAula.PQRS.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        Optional<UserDTO> userOptional = userService.findById(userDTO.getUser());
        if(userOptional.isPresent()) {
            userService.save(userDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


