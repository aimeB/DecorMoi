package com.decormoi.app.web.rest;

import com.decormoi.app.domain.Authority;
import com.decormoi.app.domain.Event;
import com.decormoi.app.domain.User;
import com.decormoi.app.repository.EventRepository;
import com.decormoi.app.security.AuthoritiesConstants;
import com.decormoi.app.service.EventQueryService;
import com.decormoi.app.service.EventService;
import com.decormoi.app.service.UserService;
import com.decormoi.app.service.criteria.EventCriteria;
import com.decormoi.app.service.dto.Stock;
import com.decormoi.app.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.*;

/**
 * REST controller for managing {@link com.decormoi.app.domain.Event}.
 */
@RestController
@RequestMapping("/api")
public class EventResource {

    private final Logger log = LoggerFactory.getLogger(EventResource.class);

    private static final String ENTITY_NAME = "event";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EventService eventService;

    private final EventRepository eventRepository;

    private final EventQueryService eventQueryService;
    private final UserService userService;

    public EventResource(
        UserService userService,
        EventService eventService,
        EventRepository eventRepository,
        EventQueryService eventQueryService
    ) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.eventQueryService = eventQueryService;
        this.userService = userService;
    }





    /**
     * {@code POST  /events} : Create a new event.
     *
     * @param event the event to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and
     * with body the new event, or with status {@code 400 (Bad Request)} if the
     * event has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) throws URISyntaxException {
        log.debug("REST request to save Event : {}", event);
        if (event.getId() != null) {
            throw new BadRequestAlertException("A new event cannot already have an ID", ENTITY_NAME, "idexists");
        }
        event.setAppartenantA(userService.getUserWithAuthorities().get());

        if (event.getProduits() != null) {
           /* if(!eventService.validQuantityProducts(event)){
                throw new BadRequestAlertException("Quantity not supported", ENTITY_NAME, "qty_not_supported");
            }*/
            if(!eventService.validCapacity(event)){
                throw new BadRequestAlertException("Capacity of not supported", ENTITY_NAME, "capacity_not_supported");
            }

            if(!eventService.minDateAccepted(event)){
                throw new BadRequestAlertException("Date not supported", ENTITY_NAME, "date_not_supported");
            }

            event.setPrix(eventService.calculateProducts(event));

            if(!eventService.minAccepted(event)){
                throw new BadRequestAlertException("Minimum accepted price", ENTITY_NAME, "min_accepted");
            }
        }
        Event result = eventService.save(event);
        return ResponseEntity
            .created(new URI("/api/events/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }





    /**
     * {@code PUT  /events/:id} : Updates an existing event.
     *
     * @param id the id of the event to save.
     * @param agentEvenements Set of users
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated event, or with status {@code 400 (Bad Request)} if the
     * event is not valid, or with status {@code 500 (Internal Server Error)} if
     * the event couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/events-assign/{id}")
    public ResponseEntity<Event> assignEvent(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody Set<User> agentEvenements)
        throws URISyntaxException {

        if (!eventRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Event result = eventService.assignAgentToEvent(id,agentEvenements);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }



    /**
     *
     * @param event
     * @return
     * @throws URISyntaxException
     */
    @PutMapping("/checkout/{id}")
    public ResponseEntity<Event> checkoutData(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody Event event) throws URISyntaxException {
        if(event == null){
            throw new BadRequestAlertException("Invalid event", ENTITY_NAME, "Event is null");
        }
        if (event.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        if (!eventRepository.existsById(event.getId())) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        event.setCheckout(true);
        Event result = eventService.save(event);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, event.getId().toString()))
            .body(result);
    }




    /**
     * {@code PUT  /events/:id} : Updates an existing event.
     *
     * @param id the id of the event to save.
     * @param event the event to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated event, or with status {@code 400 (Bad Request)} if the
     * event is not valid, or with status {@code 500 (Internal Server Error)} if
     * the event couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody Event event)
        throws URISyntaxException {
        log.debug("REST request to update Event : {}, {}", id, event);
        if (event.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, event.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!eventRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        if (event.getProduits() != null) {
           /* if(!eventService.validQuantityProducts(event)){
                throw new BadRequestAlertException("Quantity not supported", ENTITY_NAME, "qty_not_supported");
            }*/
            if(!eventService.validCapacity(event)){
                throw new BadRequestAlertException("Capacity of not supported", ENTITY_NAME, "capacity_not_supported");
            }

            if(!eventService.minDateAccepted(event)){
                throw new BadRequestAlertException("Date not supported", ENTITY_NAME, "date_not_supported");
            }

            event.setPrix(eventService.calculateProducts(event));

            if(!eventService.minAccepted(event)){
                throw new BadRequestAlertException("Minimum accepted price", ENTITY_NAME, "min_accepted");
            }
        }
        Event result = eventService.save(event);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, event.getId().toString()))
            .body(result);
    }


    /**
     * {@code PATCH  /events/:id} : Partial updates given fields of an existing
     * event, field will ignore if it is null
     *
     * @param id the id of the event to save.
     * @param event the event to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated event, or with status {@code 400 (Bad Request)} if the
     * event is not valid, or with status {@code 404 (Not Found)} if the event
     * is not found, or with status {@code 500 (Internal Server Error)} if the
     * event couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping("/events/{id}")
    public ResponseEntity<Event> partialUpdateEvent(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody Event event
    ) throws URISyntaxException {
        log.debug("REST request to partial update Event partially : {}, {}", id, event);

        if (event.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, event.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!eventRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        if (event.getProduits() != null) {
           /* if(!eventService.validQuantityProducts(event)){
                throw new BadRequestAlertException("Quantity not supported", ENTITY_NAME, "qty_not_supported");
            }*/
            if(!eventService.validCapacity(event)){
                throw new BadRequestAlertException("Capacity not supported", ENTITY_NAME, "capacity_not_supported");
            }

            if(!eventService.minDateAccepted(event)){
                throw new BadRequestAlertException("Date not supported", ENTITY_NAME, "date_not_supported");
            }


            event.setPrix(event.getProduits().stream().map(p -> p.getPrix()).reduce(0.0, (a, b) -> a + b));
            if(!eventService.minAccepted(event)){
                throw new BadRequestAlertException("Minimum accepted price", ENTITY_NAME, "min_accepted");
            }
        }
        Optional<Event> result = eventService.partialUpdate(event);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, event.getId().toString())
        );
    }






    /**
     * {@code GET  /events} : get all the events.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the
     * list of events in body.
     */
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents(EventCriteria criteria, Pageable pageable) {
        Set<Authority> authorities = userService.getUserWithAuthorities().get().getAuthorities();
        if (!authorities.stream().anyMatch(a -> a.getName().equals(AuthoritiesConstants.ADMIN))) {
            LongFilter longFilter = new LongFilter();
            longFilter.setEquals(userService.getUserWithAuthorities().get().getId());
            criteria.setAppartenantAId(longFilter);

            if (authorities.stream().anyMatch(a -> a.getName().equals(AuthoritiesConstants.AGENT))){
                criteria.setAgentEvenementId(longFilter);
            }
        }

        log.debug("REST request to get Events by criteria: {}", criteria);
        Page<Event> page = eventService.validDateOfEvents(eventQueryService.findByCriteria(criteria, pageable));

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }





    /**
     * {@code GET  /events/count} : count all the events.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the
     * count in body.
     */
    @GetMapping("/events/count")
    public ResponseEntity<Long> countEvents(EventCriteria criteria) {
        log.debug("REST request to count Events by criteria: {}", criteria);
        return ResponseEntity.ok().body(eventQueryService.countByCriteria(criteria));
    }


    /**
     * {@code GET  /events/percentage} : Get all the events with percentage.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the
     * count in body.
     */
    @GetMapping("/events/percentage")
    public ResponseEntity<Map<LocalDate, Stock>> eventPercentage() {
        return ResponseEntity.ok().body(eventService.checkStock());
    }





    /**
     * {@code GET  /events/:id} : get the "id" event.
     *
     * @param id the id of the event to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the event, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        log.debug("REST request to get Event : {}", id);
        Optional<Event> event = eventService.findOne(id);
        /*if (userService.getUserWithAuthorities().get().getAuthorities().stream().anyMatch(a -> a.getName().equals("ROLE_ADMIN"))) {
            event = eventService.findOne(id);
        } else {
            event = eventService.findOneByUserId(userService.getUserWithAuthorities().get().getId(), id);
        }*/
        return ResponseUtil.wrapOrNotFound(event);
    }




    /**
     * {@code DELETE  /events/:id} : delete the "id" event.
     *
     * @param id the id of the event to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        log.debug("REST request to delete Event : {}", id);
        //eventService.backQuantity(id);
        eventService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
