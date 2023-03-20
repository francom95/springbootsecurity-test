package com.pruebasSpringSecurity.pruebasSpringSecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.PersonaDTO;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Persona;
import com.pruebasSpringSecurity.pruebasSpringSecurity.exception.UserAlreadyRegisteredException;

public interface PersonaService {

	List<PersonaDTO> listAll();
	
	Page<PersonaDTO> listAll(Pageable pageable);
	
	PersonaDTO create(Persona persona) throws UserAlreadyRegisteredException;
	
	PersonaDTO getById(Long id);
	
	PersonaDTO update(PersonaDTO persona);
	
	Boolean delete(PersonaDTO persona);
	
}
