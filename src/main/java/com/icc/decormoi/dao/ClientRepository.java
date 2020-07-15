package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
