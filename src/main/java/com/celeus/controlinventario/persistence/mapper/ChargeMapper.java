package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ChargeDto;
import com.celeus.controlinventario.persistence.entity.Charge;

@Component
public class ChargeMapper {

	public ChargeDto entityToDto(Charge charge) {
		return ChargeDto.builder()
				.id(charge.getId())
				.name(charge.getName())
				.build();
	}
	
	public Charge dtoToEntity(ChargeDto chargeDto) {
		return Charge.builder()
				.id(chargeDto.getId())
				.name(chargeDto.getName())
				.build();
	}
}
