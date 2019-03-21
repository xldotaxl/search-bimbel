package it.aldi.app.repository;

import it.aldi.app.domain.BimbelUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the BimbelUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BimbelUserRepository extends JpaRepository<BimbelUser, Long> {

    @Query(value = "select distinct bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations left join fetch bimbel_user.roles",
        countQuery = "select count(distinct bimbel_user) from BimbelUser bimbel_user")
    Page<BimbelUser> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations left join fetch bimbel_user.roles")
    List<BimbelUser> findAllWithEagerRelationships();

    @Query("select bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations left join fetch bimbel_user.roles where bimbel_user.id =:id")
    Optional<BimbelUser> findOneWithEagerRelationships(@Param("id") Long id);

}
