package com.celeus.controlinventario.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	
	Optional<Worker> findByIdentification(String identification);

}
