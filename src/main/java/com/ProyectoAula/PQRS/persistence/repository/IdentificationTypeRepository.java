package com.ProyectoAula.PQRS.persistence.repository;

import com.ProyectoAula.PQRS.persistence.entity.IdentificationType;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {
}
