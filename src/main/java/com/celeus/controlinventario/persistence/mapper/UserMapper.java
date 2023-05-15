package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.persistence.entity.User;

@Component
public class UserMapper {

	public UserDto entityToDto(User user) {
	  return UserDto.builder()
		.email(user.getEmail())
		.enabled(user.getEnabled())
		.password(user.getPassword())
		.username(user.getUsername())
		.id(user.getId())
		.build();
	 
	}
	
	public User dtoToEntity(UserDto userDto) {
		return User.builder()
				.id(userDto.getId())
				.username(userDto.getUsername())
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.enabled(userDto.getEnabled())
				.build();
	}
}
