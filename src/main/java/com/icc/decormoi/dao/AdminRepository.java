package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {

}
