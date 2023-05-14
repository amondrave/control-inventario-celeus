package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.persistence.entity.Worker;

@Repository
public interface WorkerConnector {

   Worker getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId);
   
   Worker createWorker(Worker worker);
   
   List<Worker> getAllWorker();
   
    
}
