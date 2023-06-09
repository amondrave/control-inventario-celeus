package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.ActiveStatus;

public interface ActiveStatusRepository extends JpaRepository<ActiveStatus, Long> {
	
	@Query("SELECT a FROM ActiveStatus a WHERE a.active.id = :activeId")
	List<ActiveStatus> findByActiveId(@Param("activeId") Long activeId);
	
	@Query("SELECT a FROM ActiveStatus a WHERE a.activeTypeStatus.id = 3 AND  a.id NOT IN (SELECT lf.activeTStatus.id FROM LeavingFormat lf) ")
	List<ActiveStatus> findActiveStatusByBadCondition();

}
