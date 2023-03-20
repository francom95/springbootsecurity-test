package com.pruebasSpringSecurity.pruebasSpringSecurity.exception;

public class UserAlreadyRegisteredException extends RuntimeException{

	private static final long serialVersionUID = 2799097156465448218L;

	@Override
	public String getMessage() {
		return "El usuario ya esta registrado";
	}
		
}
