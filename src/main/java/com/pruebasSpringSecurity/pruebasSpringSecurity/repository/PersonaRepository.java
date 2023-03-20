package com.pruebasSpringSecurity.pruebasSpringSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	Optional<Persona> findById(Long id);
	
}
