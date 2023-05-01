package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.MaintenanceType;

public interface MaintenanceTypeRepository extends JpaRepository<MaintenanceType, Long> {

}
