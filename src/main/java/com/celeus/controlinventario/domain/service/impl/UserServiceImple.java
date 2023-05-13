package com.celeus.controlinventario.domain.service.impl;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.UserConnector;
import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.domain.service.UserService;
import com.celeus.controlinventario.domain.utils.Utils;

@Service
public class UserServiceImple implements UserService{
	
	private final UserConnector userConnector;
	
	public UserServiceImple(UserConnector userConnector) {
		this.userConnector = userConnector;
	}

	@Override
	public UserDto login(UserDto userDto) {
		// TODO Auto-generated method stub
		if(Utils.isEmailValid(userDto.getEmail())){
			UserDto userDtoResponse = userConnector.getUserByEmail(userDto.getEmail());
			
			if(userDtoResponse.getPassword().equalsIgnoreCase(userDto.getPassword())) {
				return userDtoResponse;
			}
		}		
		
		return null;
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
