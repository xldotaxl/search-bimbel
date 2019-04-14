package it.aldi.app.service.domain.impl;

import it.aldi.app.service.domain.PrivilegeService;
import it.aldi.app.domain.Privilege;
import it.aldi.app.repository.PrivilegeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Privilege.
 */
@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    private final Logger log = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

    private final PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    /**
     * Save a privilege.
     *
     * @param privilege the entity to save
     * @return the persisted entity
     */
    @Override
    public Privilege save(Privilege privilege) {
        log.debug("Request to save Privilege : {}", privilege);
        return privilegeRepository.save(privilege);
    }

    /**
     * Get all the privileges.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Privilege> findAll() {
        log.debug("Request to get all Privileges");
        return privilegeRepository.findAll();
    }


    /**
     * Get one privilege by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Privilege> findOne(Long id) {
        log.debug("Request to get Privilege : {}", id);
        return privilegeRepository.findById(id);
    }

    /**
     * Delete the privilege by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Privilege : {}", id);
        privilegeRepository.delete(id);
    }
}
