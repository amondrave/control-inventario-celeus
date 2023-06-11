package com.celeus.controlinventario.domain.connector.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.UserConnector;
import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.persistence.entity.User;
import com.celeus.controlinventario.persistence.mapper.UserMapper;
import com.celeus.controlinventario.persistence.repository.UserRepository;


@Repository
public class UserConnectorImpl implements UserConnector{
	
	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	public UserConnectorImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<User> opUser = userRepository.findByEmail(email);
		if(opUser.isEmpty())
			return null;
		return userMapper.entityToDto(opUser.get());
	}

	@Override
	public UserDto getUserById(Long id) {
		try {
			User user = userRepository.getById(id);
			return userMapper.entityToDto(user);
		} catch (Exception e) {
			throw new NoSuchElementException("No se pudo encontrar el usuario. ");
		}
	}

}
