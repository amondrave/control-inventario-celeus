package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.ActiveAssignment;

public interface ActiveAssignmentRepository extends JpaRepository<ActiveAssignment, Long>{
	
	@Query("SELECT a FROM ActiveAssignment a WHERE a.active.id = :id ")
	List<ActiveAssignment> findActiveAssignmentByActiveId(@Param("id") Long id);

}
