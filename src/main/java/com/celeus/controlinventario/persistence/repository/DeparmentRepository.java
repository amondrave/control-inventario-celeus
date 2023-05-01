package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Deparment;

public interface DeparmentRepository extends JpaRepository<Deparment, Long> {

}
