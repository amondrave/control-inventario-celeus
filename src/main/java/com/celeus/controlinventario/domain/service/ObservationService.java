package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ObservationDto;

public interface ObservationService {
	
	ObservationDto createObservatio(ObservationDto observationDto);
	
	ObservationDto getIdObservationById(Long id);
	
	List<ObservationDto> getAll();
	
	List<ObservationDto> getObservationByIdMaintenance(Long idMaintenance);
	
	void deleteObservation(Long id);

}
