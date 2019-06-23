package it.aldi.app.service.domain.impl;

import it.aldi.app.domain.BimbelUser;
import it.aldi.app.repository.BimbelUserRepository;
import it.aldi.app.service.domain.BimbelUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder passwordEncoder;

    public BimbelUserServiceImpl(BimbelUserRepository bimbelUserRepository, PasswordEncoder passwordEncoder) {
        this.bimbelUserRepository = bimbelUserRepository;
        this.passwordEncoder = passwordEncoder;
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
        String encodedPassword = passwordEncoder.encode(bimbelUser.getPassword());
        return bimbelUserRepository.save(bimbelUser.withPassword(encodedPassword));
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
    @Override
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

    @Override
    public BimbelUser findByUsername(String username) {
        log.debug("Request to get BimbelUser : {}", username);
        return bimbelUserRepository.findByUsername(username)
            .orElse(null);
    }

    @Override
    public BimbelUser findByEmail(String email) {
        log.debug("Request to get BimbelUser : {}", email);
        return bimbelUserRepository.findByEmail(email)
            .orElse(null);
    }

    @Override
    public List<BimbelUser> findByOrganizationAndRole(Long organizationId, String role) {
        return bimbelUserRepository.findAllByOrganizationAndRole(organizationId, role);
    }
}
