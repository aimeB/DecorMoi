package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

}
