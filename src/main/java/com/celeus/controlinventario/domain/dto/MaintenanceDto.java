package com.celeus.controlinventario.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MaintenanceDto {

	private Long id;
	
	private ActiveDto activeDto;
	
	private MaintenanceTypeDto maintenanceTypeDto;
	
	private UserDto userDto;

	private LocalDateTime createdDate;
	
	// Atributos para la proyeccion
	
	List<ObservationDto> listObservation;
	
	List<EvidenceDto> listEvidence;
	
}
