package com.icc.decormoi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icc.decormoi.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	
	
	
	
}
