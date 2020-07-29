package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Evenement;
import com.icc.decormoi.entities.Fiche;

public interface FicheRepository extends JpaRepository<Fiche, Long> {

}
