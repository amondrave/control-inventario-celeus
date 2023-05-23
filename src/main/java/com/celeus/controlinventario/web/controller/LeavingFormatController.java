package com.celeus.controlinventario.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.service.LeavingFormatService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/LeavingFormat")
public class LeavingFormatController {

	
	private final LeavingFormatService leavingFormatService;

	public LeavingFormatController(LeavingFormatService leavingFormatService) {
		super();
		this.leavingFormatService = leavingFormatService;
	}
	
	
	
}
