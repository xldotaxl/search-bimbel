package it.aldi.app.repository;

import it.aldi.app.domain.Privilege;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data  repository for the Privilege entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Optional<Privilege> findById(Long id);
}
