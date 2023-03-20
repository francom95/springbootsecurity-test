package com.pruebasSpringSecurity.pruebasSpringSecurity.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.PersonaDTO;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Persona;
import com.pruebasSpringSecurity.pruebasSpringSecurity.exception.UserAlreadyRegisteredException;
import com.pruebasSpringSecurity.pruebasSpringSecurity.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{

	private PersonaRepository personaRepository;
	
	public PersonaServiceImpl(PersonaRepository personaRepository) {
		this.personaRepository=personaRepository;
	}
	
	@Override
	public List<PersonaDTO> listAll() {
		List<Persona> personas = personaRepository.findAll();
		List<PersonaDTO> personasDTO = new ArrayList<>();
		for(Persona p: personas) {
			personasDTO.add(new PersonaDTO(p));
		}
		return personasDTO;
	}

	@Override
	public PersonaDTO getById(Long id) {
		Optional<Persona> p = personaRepository.findById(id);
		if(p.isPresent()) {
			return new PersonaDTO(p.get());
		}else {
			return null;
		}
	}

	@Override
	public PersonaDTO update(PersonaDTO persona) {
		Optional<Persona> p = personaRepository.findById(persona.getId());
		if(p.isPresent()) {
			return new PersonaDTO(personaRepository.save(p.get()));	
		}else {
			return null;
		}
	}

	@Override
	public Boolean delete(PersonaDTO persona) {
		Optional<Persona> p = personaRepository.findById(persona.getId());
		if(p.isPresent()) {
			personaRepository.delete(p.get());			
			return true;
		}else {
			return false;
		}
	}

	@Override
	public PersonaDTO create(Persona persona) throws UserAlreadyRegisteredException {
		try {
			Persona personaResultante = personaRepository.save(persona);
			return new PersonaDTO(personaResultante);
		}catch(DataIntegrityViolationException e1) {
			throw new UserAlreadyRegisteredException();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Page<PersonaDTO> listAll(Pageable pageable) {
		PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.DESC, "amount")));
		Page<Persona> personas = personaRepository.findAll(pageRequest);
		List<PersonaDTO> personasDTO = new ArrayList<>();
		for(Persona p: personas) {
			personasDTO.add(new PersonaDTO(p));
		}
		Page<PersonaDTO> personasDTOPage = new PageImpl<>(personasDTO);
		return personasDTOPage;
	}

}
