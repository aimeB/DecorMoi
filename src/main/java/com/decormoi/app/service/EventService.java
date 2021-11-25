package com.decormoi.app.service;

import com.decormoi.app.domain.Event;
import com.decormoi.app.domain.Produit;
import com.decormoi.app.domain.User;
import com.decormoi.app.domain.enums.ImpactType;
import com.decormoi.app.domain.enums.OrderStatus;
import com.decormoi.app.repository.EventRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

import com.decormoi.app.web.rest.errors.BadRequestAlertException;
import io.undertow.util.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Event}.
 */
@Service
@Transactional
public class EventService {

    private final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;
    private final ProduitService produitService;

    public EventService(EventRepository eventRepository, ProduitService produitService) {
        this.eventRepository = eventRepository;
        this.produitService = produitService;
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
     * Partially update a event.
     *
     * @param event the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Event> partialUpdate(Event event) {
        System.out.println("*************************Je rentre dans la méthode partialUpdate du service");
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

                    if(event.getOrderStatus() != null){
                        existingEvent.setOrderStatus(event.getOrderStatus());
                    }

                    return existingEvent;
                }
            )
            .map(eventRepository::save);
    }



    public Event assignAgentToEvent(Long id, Set<User> agentEvenements ){
        Event event = eventRepository.findOneWithEagerRelationships(id).get();
        event.setAgentEvenements(agentEvenements);
        return eventRepository.save(event);
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

    public void backQuantity(Long id){
        Event event = eventRepository.findById(id).get();
        event.getProduits().forEach(p -> {
            int qty = 0;
            if(p.getImpactPrice() == ImpactType.PERSON){
                qty = p.getQuantity() + event.getNbPerson();
            }else if(p.getImpactPrice() == ImpactType.TABLE){
                qty = p.getQuantity() + event.getNbTable();
            }else{
                qty = p.getQuantity() + 1;
            }
            p.setQuantity(qty);
            produitService.partialUpdate(p);
        });
    }

    public Double calculateProducts(Event event) {

        return event.getProduits().stream().map(p -> {
            double total = 0;
            int qty = 0;
            if(p.getImpactPrice() == ImpactType.PERSON){
                p.setQuantity(p.getQuantity() - event.getNbPerson());
                total = p.getPrix() * event.getNbPerson();
            }else if(p.getImpactPrice() == ImpactType.TABLE){
                p.setQuantity(p.getQuantity() - event.getNbTable());
                total = p.getPrix() * event.getNbTable();
            }else{
                total =  p.getPrix();
                p.setQuantity(p.getQuantity() - 1);
            }
            produitService.partialUpdate(p);
            return total;

        }).reduce(0.0, (a, b) -> a + b);
    }

    public boolean validQuantityProducts(Event event){
        for (Produit p :event.getProduits()) {
            if(p.getImpactPrice() == ImpactType.PERSON){
                if((p.getQuantity() - event.getNbPerson()) < 0){
                    return false;
                }
            }else if(p.getImpactPrice() == ImpactType.TABLE){
                if((p.getQuantity() - event.getNbTable()) < 0){
                    return false;
                }
            }
            if(p.getQuantity() < 0){
                return false;
            }
        }
        return true;
    }

    public boolean minAccepted(Event event){
        return event.getPrix() >= 150;
    }

    public boolean minDateAccepted(Event event){
        return event.getDateEvenement().isAfter(Instant.now());
    }

    public boolean validCapacity(Event event) {
        return event.getNbPerson() <= event.getSalle().getCapacity() ;
    }

    public Page<Event> validDateOfEvents(Page<Event> events) {
        events.map(event -> {
            if(event.getDateEvenement().isBefore(Instant.now())){
                event.setOrderStatus(OrderStatus.CANCELED);
            }
            return event;
        });
        return events;
    }
}
