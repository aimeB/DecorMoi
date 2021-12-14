package com.decormoi.app.repository;

import com.decormoi.app.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data SQL repository for the Event entity.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
    @Query("select event from Event event where event.appartenantA.login = ?#{principal.username}")
    List<Event> findByAppartenantAIsCurrentUser();


    @Query("select event from Event event where event.appartenantA.login <> ?#{principal.username} and event.orderStatus = 'PAYED'")
    List<Event> findAllOtherEventOfOneSpecificDate();

    Optional<Event> findByIdAndAppartenantAId(long eventId, long userId);

    @Query(
        value = "select distinct event from Event event left join fetch event.agentEvenements left join fetch event.produits",
        countQuery = "select count(distinct event) from Event event"
    )
    Page<Event> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct event from Event event left join fetch event.agentEvenements left join fetch event.produits")
    List<Event> findAllWithEagerRelationships();


    List<Event> findAll();


    @Query("select event from Event event left join fetch event.agentEvenements left join fetch event.produits where event.id =:id")
    Optional<Event> findOneWithEagerRelationships(@Param("id") Long id);

}
