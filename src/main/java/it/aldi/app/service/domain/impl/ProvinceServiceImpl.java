package it.aldi.app.service.impl;

import it.aldi.app.domain.Province;
import it.aldi.app.repository.ProvinceRepository;
import it.aldi.app.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Province.
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    private final Logger log = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    /**
     * Save a province.
     *
     * @param province the entity to save
     * @return the persisted entity
     */
    @Override
    public Province save(Province province) {
        log.debug("Request to save Province : {}", province);
        return provinceRepository.save(province);
    }

    /**
     * Get all the provinces.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Province> findAll() {
        log.debug("Request to get all Provinces");
        return provinceRepository.findAll();
    }

    /**
     * Get one province by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Province> findOne(Long id) {
        log.debug("Request to get Province : {}", id);
        return provinceRepository.findById(id);
    }

    /**
     * Delete the province by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Province : {}", id);
        provinceRepository.delete(id);
    }
}
