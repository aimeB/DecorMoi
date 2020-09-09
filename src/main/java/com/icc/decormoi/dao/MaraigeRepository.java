package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.GardenParty;
import com.icc.decormoi.domaine.Mariage;

public interface MaraigeRepository  extends JpaRepository<Mariage, Long> {

}
