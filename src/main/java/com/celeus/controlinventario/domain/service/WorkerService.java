package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.WorkerDto;

public interface WorkerService {
	
	WorkerDto getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId);

	WorkerDto createWorker(WorkerDto workerDto);
	
	List<WorkerDto> getAllWorker();
}
