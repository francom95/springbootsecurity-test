package com.pruebasSpringSecurity.pruebasSpringSecurity.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.ImageDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.MessageDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.ProfileDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.SignUpDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.UserDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.UserSummaryDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Usuario;
import com.pruebasSpringSecurity.pruebasSpringSecurity.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {

	private UsuarioRepository usuarioRepository;
	
	public UserServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}
	
    public ProfileDto getProfile(Long userId) {
        return new ProfileDto(new UserSummaryDto(1L, "Sergio", "Lema"),
                Arrays.asList(new UserSummaryDto(2L, "John", "Doe")),
                Arrays.asList(new MessageDto(1L, "My message")),
                Arrays.asList(new ImageDto(1L, "Title", null)));
    }

    public void addFriend(Long friendId) {
        // nothing to do at the moment
    }

    public List<UserSummaryDto> searchUsers(String term) {
        return Arrays.asList(new UserSummaryDto(1L, "Sergio", "Lema"),
                new UserSummaryDto(2L, "John", "Doe"));
    }

    public UserDto signUp(SignUpDto user) {
    	Usuario usuario = new Usuario(user);
    	Usuario usuarioResult = usuarioRepository.save(usuario);
    	if(usuarioResult != null) {
    		return new UserDto(usuarioResult,"token");
    	}else {
    		return null;
    	}
    }

    public void signOut(UserDto user) {
        // nothing to do at the moment
    }

	@Override
	public Usuario findByEmail(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		if(usuario.isPresent())	return usuario.get();
		else return null;
	}
}