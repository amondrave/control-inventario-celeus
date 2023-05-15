package com.celeus.controlinventario.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ChargeConnector;
import com.celeus.controlinventario.domain.dto.ChargeDto;
import com.celeus.controlinventario.domain.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService{
	
	private final ChargeConnector chargeConnector;
	
	
	

	public ChargeServiceImpl(ChargeConnector chargeConnector) {
		super();
		this.chargeConnector = chargeConnector;
	}



	@Override
	public List<ChargeDto> getAllCharge() {
		// TODO Auto-generated method stub
		return chargeConnector.getAllCharge();
	}

}
