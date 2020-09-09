package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.domaine.Event;

public interface EvenementRepository extends JpaRepository<Event, Long> {

}
