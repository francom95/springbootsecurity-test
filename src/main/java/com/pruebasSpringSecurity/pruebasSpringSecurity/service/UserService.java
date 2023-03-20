package com.pruebasSpringSecurity.pruebasSpringSecurity.service;

import java.util.List;

import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.ProfileDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.SignUpDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.UserDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.dto.UserSummaryDto;
import com.pruebasSpringSecurity.pruebasSpringSecurity.entity.Usuario;
public interface UserService {
	
	 public ProfileDto getProfile(Long userId);
	 
	 public void addFriend(Long friendId);
	 
	 public List<UserSummaryDto> searchUsers(String term);
	 
	 public UserDto signUp(SignUpDto user);
	 
	 public void signOut(UserDto user);
	 
	 public Usuario findByEmail(String email);
	 
}
