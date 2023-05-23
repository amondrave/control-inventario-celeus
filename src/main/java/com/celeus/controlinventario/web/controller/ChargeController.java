package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ChargeDto;
import com.celeus.controlinventario.domain.service.ChargeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/charge")
public class ChargeController {
	
	private final ChargeService chargeService;

	public ChargeController(ChargeService chargeService) {
		super();
		this.chargeService = chargeService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ChargeDto>> getAll(){
		List<ChargeDto> listChargeDtos = chargeService.getAllCharge();
		return new ResponseEntity<List<ChargeDto>>(listChargeDtos,HttpStatus.ACCEPTED);
	}

}
