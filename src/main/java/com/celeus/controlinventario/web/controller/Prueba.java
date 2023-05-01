package com.celeus.controlinventario.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

	@GetMapping("hello")
	public String hello() {
		return "Hola mundo";
	}
	
}
