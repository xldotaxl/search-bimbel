package it.aldi.app.service.impl;

import it.aldi.app.service.BimbelUserService;
import it.aldi.app.domain.BimbelUser;
import it.aldi.app.repository.BimbelUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing BimbelUser.
 */
@Service
@Transactional
public class BimbelUserServiceImpl implements BimbelUserService {

    private final Logger log = LoggerFactory.getLogger(BimbelUserServiceImpl.class);

    private final BimbelUserRepository bimbelUserRepository;

    public BimbelUserServiceImpl(BimbelUserRepository bimbelUserRepository) {
        this.bimbelUserRepository = bimbelUserRepository;
    }

    /**
     * Save a bimbelUser.
     *
     * @param bimbelUser the entity to save
     * @return the persisted entity
     */
    @Override
    public BimbelUser save(BimbelUser bimbelUser) {
        log.debug("Request to save BimbelUser : {}", bimbelUser);
        return bimbelUserRepository.save(bimbelUser);
    }

    /**
     * Get all the bimbelUsers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BimbelUser> findAll() {
        log.debug("Request to get all BimbelUsers");
        return bimbelUserRepository.findAllWithEagerRelationships();
    }

    /**
     * Get all the BimbelUser with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<BimbelUser> findAllWithEagerRelationships(Pageable pageable) {
        return bimbelUserRepository.findAllWithEagerRelationships(pageable);
    }
    

    /**
     * Get one bimbelUser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BimbelUser> findOne(Long id) {
        log.debug("Request to get BimbelUser : {}", id);
        return bimbelUserRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the bimbelUser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BimbelUser : {}", id);
        bimbelUserRepository.delete(id);
    }
}
