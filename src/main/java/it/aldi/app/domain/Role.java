package it.aldi.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * A Role.
 */
@Entity
@AllArgsConstructor
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<BimbelUser> bimbelUsers;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "role_privilege",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Set<Privilege> privileges;

    private Role() {
    }

    private Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role valueOf(Long id, String name) {
        return new Role(id, name);
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Role name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BimbelUser> getBimbelUsers() {
        return Collections.unmodifiableSet(bimbelUsers);
    }

    public Role bimbelUsers(Set<BimbelUser> bimbelUsers) {
        this.bimbelUsers = Collections.unmodifiableSet(bimbelUsers);
        return this;
    }

    public Role addBimbelUser(BimbelUser bimbelUser) {
        bimbelUsers.add(bimbelUser);
        bimbelUser.getRoles().add(this);
        return this;
    }

    public Role removeBimbelUser(BimbelUser bimbelUser) {
        bimbelUsers.remove(bimbelUser);
        bimbelUser.getRoles().remove(this);
        return this;
    }

    public void setBimbelUsers(Set<BimbelUser> bimbelUsers) {
        this.bimbelUsers = Collections.unmodifiableSet(bimbelUsers);
    }

    public Set<Privilege> getPrivileges() {
        return Collections.unmodifiableSet(privileges);
    }

    public Role privileges(Set<Privilege> privileges) {
        this.privileges = Collections.unmodifiableSet(privileges);
        return this;
    }

    public Role addPrivilege(Privilege privilege) {
        privileges.add(privilege);
        privilege.getRoles().add(this);
        return this;
    }

    public Role removePrivilege(Privilege privilege) {
        privileges.remove(privilege);
        privilege.getRoles().remove(this);
        return this;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = Collections.unmodifiableSet(privileges);
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return role.id != null && id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Role{" +
            "id=" + id +
            ", name='" + name + "'" +
            "}";
    }
}
