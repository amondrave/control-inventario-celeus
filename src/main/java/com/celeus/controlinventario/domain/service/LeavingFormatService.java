package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.LeavingFormatDto;

public interface LeavingFormatService {
	
	List<LeavingFormatDto> getAllLeavingFormat();
	
	List<LeavingFormatDto>  getAllLeavingFormatByActiveId(Long idActive);
	
	LeavingFormatDto createLeavingFormat(LeavingFormatDto leavingFormatDto);
	
	LeavingFormatDto getLeavingFormatDtoById(Long id);

}
