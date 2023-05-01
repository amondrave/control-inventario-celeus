package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{

}
