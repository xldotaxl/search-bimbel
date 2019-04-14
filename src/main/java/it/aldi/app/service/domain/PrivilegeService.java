package it.aldi.app.service.domain;

import it.aldi.app.domain.Privilege;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Privilege.
 */
public interface PrivilegeService {

    /**
     * Save a privilege.
     *
     * @param privilege the entity to save
     * @return the persisted entity
     */
    Privilege save(Privilege privilege);

    /**
     * Get all the privileges.
     *
     * @return the list of entities
     */
    List<Privilege> findAll();


    /**
     * Get the "id" privilege.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Privilege> findOne(Long id);

    /**
     * Delete the "id" privilege.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
