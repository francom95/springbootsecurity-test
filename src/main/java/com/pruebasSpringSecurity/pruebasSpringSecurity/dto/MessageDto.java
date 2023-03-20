package com.pruebasSpringSecurity.pruebasSpringSecurity.dto;

public class MessageDto {

	private Long id;
	
	private String content;

	public MessageDto() {}
	
	public MessageDto(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
