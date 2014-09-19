package com.pact.identity.domain.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by apple on 7/29/14.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, unique = true)
    private String name;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name = "roles_users",
            joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name="userId"))
    private Set<User> users;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name = "roles_resources",
            joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name = "resourceId")
    )
    private Set<Resource> resources;

    @Column(length = 100)
    private String description;

    @Column
    private Boolean enabled;
}
