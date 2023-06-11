package com.celeus.controlinventario.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.DocumentType;
import com.celeus.controlinventario.persistence.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	
	Optional<Worker> findByIdentification(String identification);

	@Query("SELECT w " +
			"FROM Worker w " +
			"WHERE w.identification = :identification " +
			"AND w.documentType.id = :documentTypeId")
	Worker findWorkerByIdentificationAndDocumentType(
	        @Param("identification") String identification, 
	        @Param("documentTypeId") Long documentTypeId);


}
