package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.ActiveType;

public interface ActiveTypeConnector {
	
	List<ActiveType> getAllActiveType();
	
	ActiveType findActiveTypeById(Long id);

}
