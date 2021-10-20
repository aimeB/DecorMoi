package com.decormoi.app.web.rest;

import com.decormoi.app.domain.EventLocation;
import com.decormoi.app.repository.EventLocationRepository;
import com.decormoi.app.service.EventLocationService;
import com.decormoi.app.service.SalleQueryService;
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
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link EventLocation}.
 */
@RestController
@RequestMapping("/api")
public class EventLocationResource {

    private final Logger log = LoggerFactory.getLogger(EventLocationResource.class);

    private static final String ENTITY_NAME = "eventLocation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EventLocationService eventLocationService;

    private final EventLocationRepository eventLocationRepository;

    private final SalleQueryService salleQueryService;

    public EventLocationResource(EventLocationService eventLocationService, EventLocationRepository eventLocationRepository, SalleQueryService salleQueryService) {
        this.eventLocationService = eventLocationService;
        this.eventLocationRepository = eventLocationRepository;
        this.salleQueryService = salleQueryService;
    }




    /**
     * {@code POST  /event-locations} : Create a new event location.
     *
     * @param eventLocation the event location to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salle, or with status {@code 400 (Bad Request)} if the salle has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/event-locations")
    public ResponseEntity<EventLocation> createEventLocation(@Valid @RequestBody EventLocation eventLocation) throws URISyntaxException {
        log.debug("REST request to save EventLocation : {}", eventLocation);
        if (eventLocation.getId() != null) {
            throw new BadRequestAlertException("A new eventLocation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EventLocation result = eventLocationService.save(eventLocation);
        return ResponseEntity
            .created(new URI("/api/event-locations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }






    /**
     * {@code GET  /event-locations} : get all the event locations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salles in body.
     */
    @GetMapping("/event-locations")
    public ResponseEntity<List<EventLocation>> getAllEventLocation(Pageable pageable) {
        Page<EventLocation> page = eventLocationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }



    /**
     * {@code GET  /salles/:id} : get the "id" salle.
     *
     * @param id the id of the salle to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salle, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/event-locations/{id}")
    public ResponseEntity<EventLocation> getSalle(@PathVariable Long id) {
        log.debug("REST request to get eventLocation : {}", id);
        Optional<EventLocation> eventLocation = eventLocationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(eventLocation);
    }


}
