package com.pruebasSpringSecurity.pruebasSpringSecurity.dto;

import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Usuario;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String token;

    public UserDto() {
        super();
    }

    public UserDto(Long id, String firstName, String lastName, String email, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
    }

    public UserDto(Usuario usuarioResult, String token) {
    	this.id = usuarioResult.getId();
    	this.firstName = usuarioResult.getFirstName();
    	this.lastName = usuarioResult.getLastName();
    	this.email = usuarioResult.getEmail();
    	this.token = token;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}