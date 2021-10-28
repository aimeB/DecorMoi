package com.decormoi.app.service;

import com.decormoi.app.domain.Event;
import com.decormoi.app.domain.User;
import com.decormoi.app.domain.enums.ImpactType;
import com.decormoi.app.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing {@link Event}.
 */
@Service
@Transactional
public class EventService {

    private final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Save a event.
     *
     * @param event the entity to save.
     * @return the persisted entity.
     */
    public Event save(Event event) {
        log.debug("Request to save Event : {}", event);
        return eventRepository.save(event);
    }


    /**
     * Assign an agent to an event.
     *
     * @param id
     * @param agentEvenements
     * @return
     */
    public Event assignAgentToEvent(Long id, Set<User> agentEvenements ){
        Event event = eventRepository.findOneWithEagerRelationships(id).get();
        event.setAgentEvenements(agentEvenements);
        return eventRepository.save(event);
    }

    /**
     * Partially update a event.
     *
     * @param event the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Event> partialUpdate(Event event) {
        log.debug("Request to partially update Event : {}", event);

        return eventRepository
            .findById(event.getId())
            .map(
                existingEvent -> {
                    if (event.getNom() != null) {
                        existingEvent.setNom(event.getNom());
                    }
                    if (event.getDateEvenement() != null) {
                        existingEvent.setDateEvenement(event.getDateEvenement());
                    }
                    if (event.getPrix() != null) {
                        existingEvent.setPrix(event.getPrix());
                    }

                    return existingEvent;
                }
            )
            .map(eventRepository::save);
    }

    /**
     * Get all the events.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Event> findAll(Pageable pageable) {
        log.debug("Request to get all Events");
        return eventRepository.findAll(pageable);
    }


    /**
     *get one event by userId
     *
     * @param userId
     * @param eventId
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<Event> findOneByUserId(long userId, long eventId) {
        log.debug("Request to get event id" + eventId);
        return eventRepository.findByIdAndAppartenantAId(eventId, userId);
    }

    
    /**
     * Get all the events with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<Event> findAllWithEagerRelationships(Pageable pageable) {
        return eventRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     * Get one event by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Event> findOne(Long id) {
        log.debug("Request to get Event : {}", id);
        return eventRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the event by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Event : {}", id);
        eventRepository.deleteById(id);
    }

    public Double calculateProducts(Event event) {
        return event.getProduits().stream().map(p -> {
            if(p.getImpactPrice() == ImpactType.PP){
                return p.getPrix() * event.getNbPerson();
            }else if(p.getImpactPrice() == ImpactType.PT){
                return p.getPrix() * event.getNbTable();
            }
            return p.getPrix();

        }).reduce(0.0, (a, b) -> a + b);
    }

}
