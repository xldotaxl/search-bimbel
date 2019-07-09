package it.aldi.app.repository;

import it.aldi.app.domain.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Organization entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findById(Long id);

    @Query(value = "select distinct organization from Organization organization left join fetch organization.roles",
        countQuery = "select count(distinct organization) from Organization organization")
    Page<Organization> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct organization from Organization organization left join fetch organization.roles")
    List<Organization> findAllWithEagerRelationships();

    @Query("select organization from Organization organization left join fetch organization.roles where organization.id =:id")
    Optional<Organization> findOneWithEagerRelationships(@Param("id") Long id);

}
