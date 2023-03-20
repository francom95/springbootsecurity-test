package com.pruebasSpringSecurity.pruebasSpringSecurity.dto;

public class ErrorRegistroPersonaDTO extends PersonaDTO{

	private String message;
	
	public ErrorRegistroPersonaDTO(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
