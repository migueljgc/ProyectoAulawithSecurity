package com.ProyectoAula.PQRS.domain.mapper;

import com.ProyectoAula.PQRS.domain.dto.*;
import com.ProyectoAula.PQRS.persistence.entity.*;

public class IdentificationTypeMapper {

    public static IdentificationType toEntity(IdentificationTypeDTO identificationTypeDTO) {
        IdentificationType identificationType = new IdentificationType();
        identificationType.setIdIdentificationType(identificationType.getIdIdentificationType());
        identificationType.setNameIdentificationType(identificationTypeDTO.getNameIdentificationType());
        return identificationType;
    }
    public static IdentificationTypeDTO toDTO(IdentificationType identificationType) {
        IdentificationTypeDTO identificationTypeDTO = new IdentificationTypeDTO();
        identificationTypeDTO.setIdIdentificationType(identificationType.getIdIdentificationType());
        identificationTypeDTO.setNameIdentificationType(identificationType.getNameIdentificationType());
        return identificationTypeDTO;
    }
}
