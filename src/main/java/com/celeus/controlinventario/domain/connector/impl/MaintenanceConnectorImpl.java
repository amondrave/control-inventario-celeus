package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.MaintenanceConnector;
import com.celeus.controlinventario.persistence.entity.Maintenance;

@Repository
public class MaintenanceConnectorImpl implements MaintenanceConnector
{

	@Override
	public List<Maintenance> getAllMaintenance() {
		// TODO Auto-generated method stub
		return null;
	}

}
