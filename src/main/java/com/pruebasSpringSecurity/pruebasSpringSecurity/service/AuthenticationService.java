package com.pruebasSpringSecurity.pruebasSpringSecurity.service;

import java.nio.CharBuffer;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.CredentialsDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.UserDto;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private UserService userService;

    public AuthenticationService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
    	// aca deberia obtener la password en md5 de la bd del usuario credentialsDto.login()
    	Usuario u = userService.findByEmail(credentialsDto.getLogin());
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap(u.getPassword()));
      
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), encodedMasterPassword)) {
            return new UserDto(u, "tokenUsuarioCreado"); // que token poner?
        }
        throw new RuntimeException("Invalid password");
    }

    public UserDto findByLogin(String login) {
        if ("login".equals(login)) {
            return new UserDto(1L, "Sergio", "Lema", "login", "token");
        }
        throw new RuntimeException("Invalid login");
    }
}