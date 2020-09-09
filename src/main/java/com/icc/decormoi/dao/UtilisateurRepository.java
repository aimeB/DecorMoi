package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.User;

public interface UtilisateurRepository extends JpaRepository<User, Long> {

}
