package com.celeus.controlinventario.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.celeus.controlinventario.persistence.entity.Active;

public interface ActiveRepository extends JpaRepository<Active, Long> {

    @Query("SELECT a FROM Active a WHERE a.enabled = true")
    List<Active> findEnabledActives();
    
    Optional<Active> findByCode(String code);
    
    @Query("SELECT COALESCE(MAX(a.id), 0) + 1 FROM Active a")
    Long getNextId();
    
    @Query("SELECT a FROM Active a INNER JOIN ActiveAssignment aa WHERE aa.returnDate IS NOT NULL "
            + "UNION "
            + "SELECT a FROM Active a WHERE NOT EXISTS (SELECT aa FROM ActiveAssignment aa WHERE aa.active = a)")
    List<Active> findActivesWithNonNullReturnDateOrWithoutAssignment();
	
}
