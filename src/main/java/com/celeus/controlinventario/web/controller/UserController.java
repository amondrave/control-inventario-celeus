package com.celeus.controlinventario.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.domain.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	private final UserService userService;
	
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping("/login")
	public ResponseEntity<UserDto> login( @RequestBody UserDto userDto){
		UserDto userDtoResponse = userService.login(userDto);
		return new ResponseEntity<UserDto>(userDtoResponse,HttpStatus.ACCEPTED);
	}
	
}
