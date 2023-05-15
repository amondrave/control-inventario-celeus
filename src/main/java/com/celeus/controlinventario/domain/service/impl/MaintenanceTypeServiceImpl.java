package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.MaintenanceTypeConnector;
import com.celeus.controlinventario.domain.dto.MaintenanceTypeDto;
import com.celeus.controlinventario.domain.service.MaintenanceTypeService;
import com.celeus.controlinventario.persistence.entity.MaintenanceType;
import com.celeus.controlinventario.persistence.mapper.MaintenanceTypeMapper;

@Service
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService {
	
	private final MaintenanceTypeConnector maintenanceTypeConnector;
	
	private final MaintenanceTypeMapper maintenanceTypeMapper;
	
	

	public MaintenanceTypeServiceImpl(MaintenanceTypeConnector maintenanceTypeConnector,
			MaintenanceTypeMapper maintenanceTypeMapper) {
		super();
		this.maintenanceTypeConnector = maintenanceTypeConnector;
		this.maintenanceTypeMapper = maintenanceTypeMapper;
	}



	@Override
	public List<MaintenanceTypeDto> getAllMaintenanceType() {
		// TODO Auto-generated method stub
		List<MaintenanceType> listMaintenanceTypes = maintenanceTypeConnector.getAllMaintenanceType();
		if(!listMaintenanceTypes.isEmpty())
			return this.maperList(listMaintenanceTypes);
		return null;
	}
	
	private List<MaintenanceTypeDto> maperList(List<MaintenanceType> listMaintenanceTypes){
		return listMaintenanceTypes.stream()
				.map(mt ->{
					MaintenanceTypeDto maintenanceTypeDto = maintenanceTypeMapper.entityToDto(mt);
					return maintenanceTypeDto;
				})
				.collect(Collectors.toList());
	}



	@Override
	public MaintenanceTypeDto getMaintenanceType(Long id) {
		// TODO Auto-generated method stub
		return maintenanceTypeMapper.entityToDto(maintenanceTypeConnector.getMaintenanceTypeById(id));
	}

}
