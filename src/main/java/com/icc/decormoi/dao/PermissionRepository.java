package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
