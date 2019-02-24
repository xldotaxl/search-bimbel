package it.aldi.app.service;

import it.aldi.app.domain.BimbelUser;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BimbelUser.
 */
public interface BimbelUserService {

    /**
     * Save a bimbelUser.
     *
     * @param bimbelUser the entity to save
     * @return the persisted entity
     */
    BimbelUser save(BimbelUser bimbelUser);

    /**
     * Get all the bimbelUsers.
     *
     * @return the list of entities
     */
    List<BimbelUser> findAll();


    /**
     * Get the "id" bimbelUser.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BimbelUser> findOne(Long id);

    /**
     * Delete the "id" bimbelUser.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
