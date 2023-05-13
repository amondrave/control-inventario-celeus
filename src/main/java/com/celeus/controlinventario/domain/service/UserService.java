package com.celeus.controlinventario.domain.service;



import com.celeus.controlinventario.domain.dto.UserDto;


public interface UserService {
	
	UserDto login(UserDto userDto);
	
	UserDto getUserById(Long id);

}
