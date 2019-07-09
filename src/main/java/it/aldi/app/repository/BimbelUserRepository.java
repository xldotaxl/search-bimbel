package it.aldi.app.repository;

import it.aldi.app.domain.BimbelUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select distinct bimbel_user from BimbelUser bimbel_user " +
        "left join fetch bimbel_user.organizations org left join fetch org.roles",
        countQuery = "select count(distinct bimbel_user) from BimbelUser bimbel_user")
    Page<BimbelUser> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations org " +
        "left join fetch org.roles")
    List<BimbelUser> findAllWithEagerRelationships();

    @Query("select bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations org " +
        "left join fetch org.roles where bimbel_user.id =:id")
    Optional<BimbelUser> findOneWithEagerRelationships(@Param("id") Long id);

    Optional<BimbelUser> findByUsername(String username);

    @Query("select bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations org " +
        "left join fetch org.roles where bimbel_user.username =:username")
    Optional<BimbelUser> findByUsernameWithEagerRelationships(@Param("username") String username);

    Optional<BimbelUser> findByEmail(String email);

    @Query("select distinct bimbel_user from BimbelUser bimbel_user left join fetch bimbel_user.organizations org " +
        "left join fetch org.roles role where org.id =:orgId and role.name =:roleName")
    List<BimbelUser> findAllByOrganizationAndRole(@Param("orgId") Long organizationId, @Param("roleName") String role);
}
