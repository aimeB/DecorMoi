package com.decormoi.app.repository;

import com.decormoi.app.domain.TypeEvenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeEvenement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeEvenementRepository extends JpaRepository<TypeEvenement, Long>, JpaSpecificationExecutor<TypeEvenement> {}
