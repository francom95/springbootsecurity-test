package com.pruebasSpringSecurity.pruebasSpringSecurity.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasSpringSecurity.pruebasSpringSecurity.service.PersonaService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.ErrorRegistroPersonaDTO;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.PersonaDTO;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Persona;
import com.pruebasSpringSecurity.pruebasSpringSecurity.exception.UserAlreadyRegisteredException;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private PersonaService personaService;
	
	public PersonaController(PersonaService personaService) {
		this.personaService=personaService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Iterable<PersonaDTO>> listar(){
		List<PersonaDTO> personas = personaService.listAll();
		return ResponseEntity.ok(personas);
	}
	
	@GetMapping("/paginable")
	public ResponseEntity<Collection<PersonaDTO>> findAll(Pageable pageable) {
	   Page<PersonaDTO> page = personaService.listAll(pageable);       
	   return ResponseEntity.ok(page.toList());
	}
	
	@PostMapping("/")
	public ResponseEntity<PersonaDTO> create(@RequestBody Persona persona){
		try {
			PersonaDTO personaResultante = personaService.create(persona);
			if(personaResultante != null) {
				return ResponseEntity.created(URI.create("/personas/"+personaResultante.getId())).body(personaResultante);
			}else {
				return ResponseEntity.badRequest().body(null);
			}
		}catch(UserAlreadyRegisteredException e) {
			return ResponseEntity.internalServerError().body(new ErrorRegistroPersonaDTO("El email ya esta registrado."));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonaDTO> update(@PathVariable Long id, @RequestBody @Valid PersonaDTO persona){
		persona.setId(id);
		// habria que chequear s ya existe y retornar created si no existe
		PersonaDTO personaDTO = personaService.update(persona);
		if(personaDTO != null) {
			return ResponseEntity.ok(personaDTO);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<PersonaDTO> update(@PathVariable Long id, @RequestBody @Valid String nombre){
		PersonaDTO persona = personaService.getById(id);
		if(persona != null) {
			persona.setNombre(nombre);
			PersonaDTO personaUpdated = personaService.update(persona);
			if(personaUpdated != null) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
