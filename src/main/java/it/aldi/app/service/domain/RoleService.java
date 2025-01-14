package it.aldi.app.service.domain;

import it.aldi.app.domain.Role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Role.
 */
public interface RoleService {

    /**
     * Save a role.
     *
     * @param role the entity to save
     * @return the persisted entity
     */
    Role save(Role role);

    /**
     * Get all the roles with eager load.
     *
     * @return the list of entities
     */
    List<Role> findAllWithEagerRelationships();

    /**
     * Get all the Role with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<Role> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" role.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Role> findOne(Long id);

    /**
     * Delete the "id" role.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Count all available role
     *
     * @return total number of roles
     */
    Long countAll();

    /**
     * Get all the roles (lazy loaded).
     *
     * @return the list of entities
     */
    List<Role> findAll();
}
