package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ChargeConnector;
import com.celeus.controlinventario.domain.dto.ChargeDto;
import com.celeus.controlinventario.persistence.entity.Charge;
import com.celeus.controlinventario.persistence.mapper.ChargeMapper;
import com.celeus.controlinventario.persistence.repository.ChargeRepository;

@Repository
public class ChargeConnectorImpl implements ChargeConnector{
	
	private final ChargeRepository chargeRepository;
	
	private final ChargeMapper chargeMapper;
	
	

	public ChargeConnectorImpl(ChargeRepository chargeRepository, ChargeMapper chargeMapper) {
		super();
		this.chargeRepository = chargeRepository;
		this.chargeMapper = chargeMapper;
	}



	@Override
	public List<ChargeDto> getAllCharge() {
		// TODO Auto-generated method stub
		List<Charge> listCharge = chargeRepository.findAll();
		return mapperList(listCharge);
	}
	
	private  List<ChargeDto> mapperList(List<Charge> listCharge){
		return listCharge.stream()
				.map(charge -> {
					ChargeDto chargeDto = chargeMapper.entityToDto(charge);
					return chargeDto;
				})
				.collect(Collectors.toList());
	}

}
