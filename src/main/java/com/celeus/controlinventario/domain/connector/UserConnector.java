package com.celeus.controlinventario.domain.connector;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.UserDto;

@Repository
public interface UserConnector {

	UserDto getUserByEmail(String email);
	
	UserDto getUserById(Long id);
}
