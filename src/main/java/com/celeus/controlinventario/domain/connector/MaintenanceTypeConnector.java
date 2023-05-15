package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.MaintenanceType;

public interface MaintenanceTypeConnector {

	List<MaintenanceType> getAllMaintenanceType();
	
	MaintenanceType getMaintenanceTypeById(Long id);
}
