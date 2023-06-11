package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ObservationConnector;
import com.celeus.controlinventario.domain.dto.ObservationDto;
import com.celeus.controlinventario.domain.service.ObservationService;
import com.celeus.controlinventario.persistence.entity.Observation;
import com.celeus.controlinventario.persistence.mapper.ObservationMapper;
@Service
public class ObservationServiceImpl implements ObservationService{
	
	private final ObservationConnector observationConnector;
	
	private final ObservationMapper observationMapper;
	
	

	public ObservationServiceImpl(ObservationConnector observationConnector, ObservationMapper observationMapper) {
		super();
		this.observationConnector = observationConnector;
		this.observationMapper = observationMapper;
	}

	@Override
	public ObservationDto createObservatio(ObservationDto observationDto) {
		// TODO Auto-generated method stub
		Observation observation = observationMapper.dtoToEntity(observationDto);
		return observationMapper.entityToDto(observationConnector.createObservation(observation));
	}

	@Override
	public ObservationDto getIdObservationById(Long id) {
		// TODO Auto-generated method stub
		return observationMapper.entityToDto(observationConnector.getObservationById(id));
	}

	@Override
	public List<ObservationDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObservationDto> getObservationByIdMaintenance(Long idMaintenance) {
		// TODO Auto-generated method stub
		List<Observation> list = observationConnector.getAllObservationByMaintenance(idMaintenance);
		if(!list.isEmpty())
			return mapperList(list);
		return null;
	}
	
	private List<ObservationDto> mapperList(List<Observation> list){
		return list.stream().map(o -> {
			ObservationDto observationDto = observationMapper.entityToDto(o);
			observationDto.setUserDto(null);
			observationDto.setMaintenanceDto(null);
			return observationDto;
		})
				.collect(Collectors.toList());
	}

	@Override
	public void deleteObservation(Long id) {
		// TODO Auto-generated method stub
		observationConnector.deleteObservation(id);
	}

}
