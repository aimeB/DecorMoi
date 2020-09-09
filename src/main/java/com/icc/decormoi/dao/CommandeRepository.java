package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
