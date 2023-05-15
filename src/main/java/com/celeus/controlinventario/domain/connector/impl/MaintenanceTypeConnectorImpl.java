package com.celeus.controlinventario.domain.connector.impl;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.MaintenanceTypeConnector;
import com.celeus.controlinventario.persistence.entity.MaintenanceType;
import com.celeus.controlinventario.persistence.repository.MaintenanceTypeRepository;

@Repository
public class MaintenanceTypeConnectorImpl implements MaintenanceTypeConnector {
	
	private final MaintenanceTypeRepository maintenanceTypeRepository;
	
	

	public MaintenanceTypeConnectorImpl(MaintenanceTypeRepository maintenanceTypeRepository) {
		super();
		this.maintenanceTypeRepository = maintenanceTypeRepository;
	}



	@Override
	public List<MaintenanceType> getAllMaintenanceType() {
		// TODO Auto-generated method stub
		return maintenanceTypeRepository.findAll();
	}



	@Override
	public MaintenanceType getMaintenanceTypeById(Long id) {
		try {
			return maintenanceTypeRepository.getReferenceById(id);
		} catch (Exception e) {
			throw new NoSuchElementException("No se puede encontrar");
		}
	}

}
