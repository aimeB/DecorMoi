package com.decormoi.app.service;

import com.decormoi.app.domain.Event;
import com.decormoi.app.domain.Produit;
import com.decormoi.app.domain.User;
import com.decormoi.app.domain.enums.ImpactType;
import com.decormoi.app.domain.enums.OrderStatus;
import com.decormoi.app.repository.EventRepository;
import com.decormoi.app.service.dto.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

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
    public Map<LocalDate, Stock> checkStock(){
        List<Event> events = eventRepository.findAll();
        Map<LocalDate, Stock> soldOut = new HashMap<>();
        for (Produit produit : produitService.findAll()) {
            for (Event event : events) {
                if(event.getProduits().contains(produit)){
                    LocalDate localDate = convertToLocalDate(event.getDateEvenement()).plusDays(1);
                    if(soldOut.containsKey(localDate)){
                        Stock stock = soldOut.get(localDate);
                        int quantity = stock.getQuantity(produit) != null ? stock.getQuantity(produit) : produit.getQuantity();
                        stock.setQuantity(produit,setQuantity(produit, quantity, event));
                    }else{
                        Stock stock = new Stock();
                        stock.setQuantity(produit, setQuantity(produit, produit.getQuantity(), event));
                        soldOut.put(localDate, stock);
                    }
                }
            }
        }

        return soldOut;
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


    private double applyTva(double amount){
        return amount * 1.21;
    }


    public Double calculateProducts(Event event) {

        return applyTva(event.getProduits().stream().map(p -> {
            double total = 0;
            int qty = 0;
            if(p.getImpactPrice() == ImpactType.PERSON){
                //p.setQuantity(p.getQuantity() - event.getNbPerson());
                total = p.getPrix() * event.getNbPerson();
            }else if(p.getImpactPrice() == ImpactType.TABLE){
                //p.setQuantity(p.getQuantity() - event.getNbTable());
                total = p.getPrix() * event.getNbTable();
            }else{
                total =  p.getPrix();
                //p.setQuantity(p.getQuantity() - 1);
            }
            //produitService.partialUpdate(p);
            return total;

        }).reduce(0.0, (a, b) -> a + b));
    }



    public boolean validQuantityProducts(Event event){
        LocalDate localDate = convertToLocalDate(event.getDateEvenement());
        List<Event> events = eventRepository
            .findAllOtherEventOfOneSpecificDate().stream()
            .filter(ev-> convertToLocalDate(ev.getDateEvenement()).equals(localDate))
            .collect(Collectors.toList());
        for (Produit produit :event.getProduits()) {
            //Quantité total du produit
            int quantityProduit = produit.getQuantity();
            for (Event otherEvent: events) {
                Optional<Produit> otherProduit = otherEvent.getProduits().stream().filter(p -> p.getId() == produit.getId()).findFirst();
                if(otherProduit.isPresent()){
                    //Modifier la quantité de chaque produit de la liste d'événement sans prendre compte de l'évenenment principal
                    quantityProduit = setQuantity(otherProduit.get(), quantityProduit, otherEvent);
                }
            }
            //Modifier finalement la quantité de l'événement principal
            quantityProduit = setQuantity(produit, quantityProduit, event);
            if(quantityProduit < 0){
                return false;
            }
        }
        return true;
    }

    private int setQuantity(Produit produit, int quantity, Event event) {
        if (produit.getImpactPrice() == ImpactType.PERSON) {
            quantity -= event.getNbPerson();
        } else if (produit.getImpactPrice() == ImpactType.TABLE) {
            quantity -= event.getNbTable();
        } else {
            quantity -= 1;
        }
        return quantity;
    }

    private LocalDate convertToLocalDate(Instant date) {
        return LocalDateTime.ofInstant(date, ZoneOffset.UTC).toLocalDate();
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
