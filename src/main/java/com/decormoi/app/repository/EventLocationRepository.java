package com.decormoi.app.repository;

import com.decormoi.app.domain.EventLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Event entity.
 */
@Repository
public interface EventLocationRepository extends JpaRepository<EventLocation, Long>, JpaSpecificationExecutor<EventLocation> {

}
