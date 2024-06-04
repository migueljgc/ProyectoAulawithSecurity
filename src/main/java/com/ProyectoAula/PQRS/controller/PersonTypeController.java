package com.ProyectoAula.PQRS.controller;

import com.ProyectoAula.PQRS.domain.common.Route;

import com.ProyectoAula.PQRS.domain.dto.PersonTypeDTO;
import com.ProyectoAula.PQRS.domain.service.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person_type")
public class PersonTypeController {
    @Autowired
    private PersonTypeService personTypeService;

    @PostMapping("/save")
    public PersonTypeDTO save(@RequestBody PersonTypeDTO personTypeDTO){
        return personTypeService.save(personTypeDTO);
    }

    @GetMapping("/get")
    public List<PersonTypeDTO> get(){return personTypeService.getAll();}

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody PersonTypeDTO personTypeDTO) {
        Optional<PersonTypeDTO> personTypeDTOOptional = personTypeService.findById(personTypeDTO.getIdPersonType());
        if(personTypeDTOOptional.isPresent()) {
            personTypeService.save(personTypeDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

