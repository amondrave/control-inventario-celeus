package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.persistence.entity.Maintenance;

@Repository
public interface MaintenanceConnector {

	List<Maintenance> getAllMaintenance();
	
	List<Maintenance> getAllMaintenanceByIdActive(Long idActive);
	
	Maintenance createMaintenance(Maintenance maintenance);
	
	Maintenance updateMaintenance(Maintenance maintenance);
	
	Maintenance getMaintenanceById(Long id);
	
}
