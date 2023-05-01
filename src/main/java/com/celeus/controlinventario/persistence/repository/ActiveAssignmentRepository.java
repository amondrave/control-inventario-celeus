package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.ActiveAssignment;

public interface ActiveAssignmentRepository extends JpaRepository<ActiveAssignment, Long>{

}
