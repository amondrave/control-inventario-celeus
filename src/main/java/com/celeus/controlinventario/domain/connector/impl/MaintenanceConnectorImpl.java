package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.MaintenanceConnector;
import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.repository.MaintenanceRepository;

@Repository
public class MaintenanceConnectorImpl implements MaintenanceConnector {
	
	private final MaintenanceRepository maintenanceRepository;
	

	public MaintenanceConnectorImpl(MaintenanceRepository maintenanceRepository) {
		super();
		this.maintenanceRepository = maintenanceRepository;
	}

	@Override
	public List<Maintenance> getAllMaintenance() {
		// TODO Auto-generated method stub
		return maintenanceRepository.findAll();
	}

	@Override
	public Maintenance createMaintenance(Maintenance maintenance) {
		// TODO Auto-generated method stub
		setUpdateDate(maintenance);
		return maintenanceRepository.saveAndFlush(maintenance);
	}

	@Override
	public Maintenance updateMaintenance(Maintenance maintenance) {
		// TODO Auto-generated method stub
		setUpdateDate(maintenance);
		return maintenanceRepository.saveAndFlush(maintenance);
	}
	
	private void setUpdateDate(Maintenance maintenance) {
		maintenance.setUpdateDate(LocalDateTime.now());
	}

	@Override
	public List<Maintenance> getAllMaintenanceByIdActive(Long idActive) {
		// TODO Auto-generated method stub
		return maintenanceRepository.findMaintenanceByActiveId(idActive);
	}

}
