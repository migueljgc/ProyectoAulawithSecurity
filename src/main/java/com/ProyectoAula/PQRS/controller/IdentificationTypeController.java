package com.ProyectoAula.PQRS.controller;


import com.ProyectoAula.PQRS.domain.common.Route;
import com.ProyectoAula.PQRS.domain.dto.IdentificationTypeDTO;
import com.ProyectoAula.PQRS.domain.service.IdentificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/identification_type")
public class IdentificationTypeController {
    @Autowired
    private IdentificationTypeService identificationTypeService;

    @PostMapping("/save")
    public IdentificationTypeDTO save(@RequestBody IdentificationTypeDTO identificationTypeDTO){
        return identificationTypeService.save(identificationTypeDTO);
    }

    @GetMapping("/get")
    public List<IdentificationTypeDTO> get(){return identificationTypeService.getAll();}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody IdentificationTypeDTO identificationTypeDTO) {
        Optional<IdentificationTypeDTO> identificationTypeDTOOptional = identificationTypeService.findById(identificationTypeDTO.getIdIdentificationType());
        if(identificationTypeDTOOptional.isPresent()) {
            identificationTypeService.save(identificationTypeDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

