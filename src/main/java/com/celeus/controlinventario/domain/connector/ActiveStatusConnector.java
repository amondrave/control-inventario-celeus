package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.ActiveStatus;

public interface ActiveStatusConnector {
	
	List<ActiveStatus> getAllActiveStatus();
	
	List<ActiveStatus> getAllActiveStatusByActive(Long activeId);
	
	ActiveStatus createActiveStatus(ActiveStatus activeStatus);
	
	ActiveStatus getActiveStatusById(Long id);
	
	void deleteActiveStatus(Long id);

}
