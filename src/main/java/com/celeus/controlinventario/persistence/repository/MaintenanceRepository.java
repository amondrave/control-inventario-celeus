package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{
	
	 @Query("SELECT m FROM Maintenance m WHERE m.active.id = :activeId")
	 List<Maintenance> findMaintenanceByActiveId(@Param("activeId") Long activeId);
}
