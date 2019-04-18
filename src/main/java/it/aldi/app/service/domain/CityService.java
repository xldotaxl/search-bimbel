package it.aldi.app.service;

import it.aldi.app.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing City.
 */
public interface CityService {

    /**
     * Save a city.
     *
     * @param city the entity to save
     * @return the persisted entity
     */
    City save(City city);

    /**
     * Get all the cities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<City> findAll(Pageable pageable);

    /**
     * Get the "id" city.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<City> findOne(Long id);

    /**
     * Delete the "id" city.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
