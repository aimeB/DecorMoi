package com.decormoi.app.service;

import com.decormoi.app.domain.EventLocation;
import com.decormoi.app.domain.Salle;
import com.decormoi.app.repository.EventLocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Salle}.
 */
@Service
@Transactional
public class EventLocationService {

    private final Logger log = LoggerFactory.getLogger(EventLocationService.class);

    private final EventLocationRepository eventLocationRepository;

    public EventLocationService(EventLocationRepository eventLocationRepository) {
        this.eventLocationRepository = eventLocationRepository;
    }

    /**
     * Save a eventLocation.
     *
     * @param eventLocation the entity to save.
     * @return the persisted entity.
     */
    public EventLocation save(EventLocation eventLocation) {
        log.debug("Request to save EventLocation : {}", eventLocation);
        return eventLocationRepository.save(eventLocation);
    }


    /**
     * Get all the eventLocation.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EventLocation> findAll(Pageable pageable) {
        log.debug("Request to get all Salles");
        return eventLocationRepository.findAll(pageable);
    }

    /**
     * Get one EventLocation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EventLocation> findOne(Long id) {
        log.debug("Request to get Salle : {}", id);
        return eventLocationRepository.findById(id);
    }

    /**
     * Delete the eventLocation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EventLocation : {}", id);
        eventLocationRepository.deleteById(id);
    }
}
