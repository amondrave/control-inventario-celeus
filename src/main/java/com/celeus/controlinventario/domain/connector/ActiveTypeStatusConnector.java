package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.ActiveTypeStatus;

public interface ActiveTypeStatusConnector {
	
	List<ActiveTypeStatus> getAllActiveTypeStatus();

}
