package com.ProyectoAula.PQRS.domain.service;


import com.ProyectoAula.PQRS.domain.dto.IdentificationTypeDTO;
import com.ProyectoAula.PQRS.domain.mapper.IdentificationTypeMapper;
import com.ProyectoAula.PQRS.persistence.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IdentificationTypeService {
    @Autowired
    private IdentificationTypeRepository identificationTypeRepository;

    public IdentificationTypeDTO save(IdentificationTypeDTO identificationTypeDTO) {
        identificationTypeRepository.save(IdentificationTypeMapper.toEntity(identificationTypeDTO));
        return identificationTypeDTO;
    }

    public List<IdentificationTypeDTO> getAll() {
        return identificationTypeRepository.findAll().stream().map(IdentificationTypeMapper::toDTO).collect(Collectors.toList());
    }
    public Optional<IdentificationTypeDTO> findById(Long id) {
        return identificationTypeRepository.findById(id).map(IdentificationTypeMapper::toDTO);
    }
}
