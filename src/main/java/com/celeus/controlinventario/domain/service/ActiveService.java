package com.celeus.controlinventario.domain.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.dto.ActiveDto;

public interface ActiveService {
	
	List<ActiveDto> getAllActivesEnabled();

	ActiveDto saveActive(ActiveDto activeDto, MultipartFile image) throws IOException;
	
	ActiveDto updateActive(ActiveDto activeDto, MultipartFile image) throws IOException;
	
	ActiveDto getActiveById(Long id);
	
	ActiveDto getActiveByCode(String code);
	
	void enabledActive(Long id);
}
