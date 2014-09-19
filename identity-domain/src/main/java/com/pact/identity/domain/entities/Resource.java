package com.pact.identity.domain.entities;

import com.pact.identity.domain.entities.Role;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by apple on 7/29/14.
 */
@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, unique = true)
    private String name;

    @Column(length = 100, unique = true)
    private String type;

    @Column
    private Integer priority;

    @Column
    @ManyToMany(mappedBy = "resources")
    private Set<Role> roles;

    @Column
    private Boolean enabled;
}
