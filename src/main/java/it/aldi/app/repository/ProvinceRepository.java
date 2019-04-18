package it.aldi.app.repository;

import it.aldi.app.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Province entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Optional<Province> findById(Long id);
}
