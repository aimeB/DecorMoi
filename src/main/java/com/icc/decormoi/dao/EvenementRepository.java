package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
