package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.GardenParty;
import com.icc.decormoi.entities.Mariage;

public interface MaraigeRepository  extends JpaRepository<Mariage, Long> {

}
