package com.pruebasSpringSecurity.pruebasSpringSecurity.entity;

import java.io.Serializable;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.SignUpDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = -490531409305543300L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;
	
	public Usuario() {}

	public Usuario(Long id, @NotEmpty String email, @NotEmpty String password, @NotEmpty String firstName,
			@NotEmpty String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Usuario(SignUpDto userSignUp) {
		this.email = userSignUp.getEmail();
		this.password = userSignUp.getPassword();
		this.firstName = userSignUp.getFirstName();
		this.lastName = userSignUp.getLastName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
