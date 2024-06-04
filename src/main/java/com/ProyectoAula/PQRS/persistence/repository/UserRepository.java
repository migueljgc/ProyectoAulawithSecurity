package com.ProyectoAula.PQRS.persistence.repository;



import com.ProyectoAula.PQRS.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional <User> findUserByEmail(String username);
}
