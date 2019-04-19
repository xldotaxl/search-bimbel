package it.aldi.app.repository;

import it.aldi.app.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the City entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findById(Long id);

    List<City> findByProvinceId(Long provinceId);
}
