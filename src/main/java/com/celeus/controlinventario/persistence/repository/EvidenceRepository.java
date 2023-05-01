package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Evidence;

public interface EvidenceRepository extends JpaRepository<Evidence, Long>{

}
