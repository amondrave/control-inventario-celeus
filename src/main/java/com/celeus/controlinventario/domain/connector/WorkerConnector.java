package com.celeus.controlinventario.domain.connector;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.WorkerDto;

@Repository
public interface WorkerConnector {

   WorkerDto getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId);
   
    
}
