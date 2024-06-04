package com.ProyectoAula.PQRS.persistence.repository;



import com.ProyectoAula.PQRS.persistence.entity.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PersonTypeRepository extends JpaRepository<PersonType, Long> {
}
