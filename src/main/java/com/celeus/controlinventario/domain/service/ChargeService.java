package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ChargeDto;

public interface ChargeService {
	
	List<ChargeDto> getAllCharge();
	
	ChargeDto getChargeById(Long id);
	

}
