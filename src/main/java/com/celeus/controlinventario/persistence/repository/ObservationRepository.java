package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.entity.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
	
	@Query("SELECT o FROM Observation o WHERE o.maintenance = :maintenance")
	List<Observation> findByMaintenance(@Param("maintenance") Maintenance maintenance);


}
