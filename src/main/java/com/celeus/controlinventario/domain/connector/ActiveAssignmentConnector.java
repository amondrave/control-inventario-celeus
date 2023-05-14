package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.ActiveAssignment;

public interface ActiveAssignmentConnector {
	
	List<ActiveAssignment> getAllActiveAssignment();
	
	List<ActiveAssignment> getAllActiveAssignmentByActive(Long activeId);

	ActiveAssignment createActiveAssignment(ActiveAssignment activeAssignment);
	
	ActiveAssignment getActiveAssignmentById(Long id);
	
	void deleteActiveAssignment(Long id);
}
