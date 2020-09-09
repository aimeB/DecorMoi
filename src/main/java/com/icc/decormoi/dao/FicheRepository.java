package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.Event;
import com.icc.decormoi.domaine.Fiche;

public interface FicheRepository extends JpaRepository<Fiche, Long> {

}
