package com.pruebasSpringSecurity.pruebasSpringSecurity.dto;

import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Persona;

public class PersonaDTO {

	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String telefono;
	
	public PersonaDTO() {}

	public PersonaDTO(Long id, String nombre, String apellido, String email, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido=apellido;
		this.email=email;
		this.telefono=telefono;
	}

	public PersonaDTO(Persona p) {
		this.id=p.getId();
		this.nombre=p.getNombre();
		this.apellido=p.getApellido();
		this.email=p.getEmail();
		this.telefono=p.getTelefono();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
