package it.aldi.app.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A BimbelUser.
 */
@Entity
@Table(name = "bimbel_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BimbelUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.]*[a-zA-Z]+$")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Pattern(regexp = "^[a-z A-Z]*$")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(min = 6)
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bimbel_user_organization",
               joinColumns = @JoinColumn(name = "bimbel_user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"))
    private Set<Organization> organizations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public BimbelUser username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public BimbelUser name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public BimbelUser password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public BimbelUser organizations(Set<Organization> organizations) {
        this.organizations = organizations;
        return this;
    }

    public BimbelUser addOrganization(Organization organization) {
        this.organizations.add(organization);
        organization.getBimbelUsers().add(this);
        return this;
    }

    public BimbelUser removeOrganization(Organization organization) {
        this.organizations.remove(organization);
        organization.getBimbelUsers().remove(this);
        return this;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
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
        BimbelUser bimbelUser = (BimbelUser) o;
        if (bimbelUser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bimbelUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BimbelUser{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
