package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ActiveAssignmentDto;

public interface ActiveAssignmentService {
	
	List<ActiveAssignmentDto> getAllActiveAssignment();
	
	
	List<ActiveAssignmentDto> getAllActiveAssignmentByActive(Long idActive);
	
	
	ActiveAssignmentDto createActiveAssignment(ActiveAssignmentDto activeAssignmentDto);
	
	
	ActiveAssignmentDto getActiveAssignmentById(Long id);
	
	
	void deleteActiveAssignment(Long id);
	

}
