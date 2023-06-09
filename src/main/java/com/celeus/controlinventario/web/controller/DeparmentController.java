package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.DeparmentDto;
import com.celeus.controlinventario.domain.service.DeparmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Deparment")
public class DeparmentController {
	
	private final DeparmentService deparmentService;

	public DeparmentController(DeparmentService deparmentService) {
		super();
		this.deparmentService = deparmentService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<DeparmentDto>> getAll(){
		List<DeparmentDto> list = deparmentService.getAllDeparment();
		System.out.print(list.size());
		return new ResponseEntity<List<DeparmentDto>>(list,HttpStatus.ACCEPTED);
	}

}
