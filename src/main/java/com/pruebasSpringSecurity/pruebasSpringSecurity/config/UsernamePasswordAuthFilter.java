package com.pruebasSpringSecurity.pruebasSpringSecurity.config;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.CredentialsDto;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter{

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private final UserAuthenticationProvider provider;
	
	public UsernamePasswordAuthFilter(UserAuthenticationProvider provider) {
		this.provider = provider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if("/auth/signIn".equals(request.getServletPath())
				&& HttpMethod.POST.matches(request.getMethod())) {
			CredentialsDto credentialsDto = MAPPER.readValue(request.getInputStream(), CredentialsDto.class);
			try {
				SecurityContextHolder.getContext().setAuthentication(
					provider.validateCredentials(credentialsDto)
				);
			}catch(RuntimeException e) {
				SecurityContextHolder.clearContext();
				throw e;
			}
			
		}
		
		filterChain.doFilter(request, response);
	}

}
