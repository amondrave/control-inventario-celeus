package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.LeavingFormat;

public interface LeavingFormatConnector {
	
	List<LeavingFormat> getAllLeavingFormat();
	
	List<LeavingFormat> getAllLeavingFormatByActiveId(Long idActive);
	
	LeavingFormat createLeavingFormat(LeavingFormat leavingFormat);
	
	LeavingFormat getLeavingFormatById(Long id);

}
