package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {

}
