package com.pact.identity.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(length = 100, unique = true)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(length = 50)
    private String salt;

    @Column
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "organizationId", referencedColumnName = "id")
    private Organization organization;

    @Column
    private Boolean enabled;

    public User(){}

    public User(String username, String password, String salt, Set<Role> roles, Organization organization, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.roles = roles;
        this.organization = organization;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
