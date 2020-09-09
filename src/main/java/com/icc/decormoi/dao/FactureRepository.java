package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long>{

}
