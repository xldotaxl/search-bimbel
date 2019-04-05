package it.aldi.app.service;

import it.aldi.app.domain.BimbelUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * Get all the BimbelUser with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<BimbelUser> findAllWithEagerRelationships(Pageable pageable);
    
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

    /**
     * Get the bimbelUser based on id
     * @param username the username of the entity
     * @return the entity
     */
    BimbelUser findByUsername(String username);
}
