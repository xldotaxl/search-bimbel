package it.aldi.app.repository;

import it.aldi.app.domain.BimbelUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data  repository for the BimbelUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BimbelUserRepository extends JpaRepository<BimbelUser, Long> {
    Optional<BimbelUser> findById(Long id);
    void deleteById(Long id);
}
