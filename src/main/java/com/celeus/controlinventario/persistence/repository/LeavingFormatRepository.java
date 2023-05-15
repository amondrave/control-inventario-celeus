package com.celeus.controlinventario.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.celeus.controlinventario.persistence.entity.LeavingFormat;

public interface LeavingFormatRepository extends JpaRepository<LeavingFormat, Long>{
	
    @Query("SELECT lf FROM LeavingFormat lf JOIN lf.activeTStatus a WHERE a.id = :activeId")
    List<LeavingFormat> findByActiveId(@Param("activeId") Long activeId);

}
