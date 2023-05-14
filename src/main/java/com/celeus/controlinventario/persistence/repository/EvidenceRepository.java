package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.Evidence;
import com.celeus.controlinventario.persistence.entity.Maintenance;

public interface EvidenceRepository extends JpaRepository<Evidence, Long>{
	
	@Query("SELECT e FROM Evidence e WHERE e.maintenance = :maintenance")
	List<Evidence> findByMaintenance(@Param("maintenance") Maintenance maintenance);


}
