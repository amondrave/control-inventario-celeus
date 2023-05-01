package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long>{

}
