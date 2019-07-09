package it.aldi.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Organization.
 */
@Entity
@Table(name = "organization")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 6)
    @Column(name = "address")
    private String address;

    @Size(max = 20)
    @Pattern(regexp = "^[0-9]*$")
    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "activated")
    private Boolean activated;

    @ManyToMany(mappedBy = "organizations", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<BimbelUser> bimbelUsers = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "organization_role",
        joinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    private Organization() {
    }

    private Organization(String name) {
        this.name = name;
        address = "Jakarta";
        phone = null;
        activated = false;
    }

    public static Organization createDefault(String name, Set<Role> roles) {
        return new Organization(name).roles(roles);
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

    public Organization name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public Organization address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public Organization phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isActivated() {
        return activated;
    }

    public Organization activated(Boolean activated) {
        this.activated = activated;
        return this;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Set<BimbelUser> getBimbelUsers() {
        return bimbelUsers;
    }

    public Organization bimbelUsers(Set<BimbelUser> bimbelUsers) {
        this.bimbelUsers = bimbelUsers;
        return this;
    }

    public Organization addBimbelUser(BimbelUser bimbelUser) {
        this.bimbelUsers.add(bimbelUser);
        bimbelUser.getOrganizations().add(this);
        return this;
    }

    public Organization removeBimbelUser(BimbelUser bimbelUser) {
        this.bimbelUsers.remove(bimbelUser);
        bimbelUser.getOrganizations().remove(this);
        return this;
    }

    public void setBimbelUsers(Set<BimbelUser> bimbelUsers) {
        this.bimbelUsers = bimbelUsers;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public Organization roles(Set<Role> roles) {
        this.roles = Collections.unmodifiableSet(roles);
        return this;
    }

    public Organization addRole(Role role) {
        roles.add(role);
        role.getOrganizations().add(this);
        return this;
    }

    public Organization removeRole(Role role) {
        roles.remove(role);
        role.getOrganizations().remove(this);
        return this;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
        Organization organization = (Organization) o;
        if (organization.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), organization.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Organization{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", activated='" + isActivated() + "'" +
            "}";
    }
}
