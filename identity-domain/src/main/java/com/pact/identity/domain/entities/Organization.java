package com.pact.identity.domain.entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by apple on 7/29/14.
 */
@Entity
@Table(name = "organizations")
@NamedNativeQueries({
//    @NamedNativeQuery(name="findChildrenByParentId",
//            query = "select o.id, o.name, o.priority, o.parentId, o.parentIds, o.enabled" +
//                    " from organizations o where o.parentId = ?"),

//    @NamedNativeQuery(name="findChildrenByParentId",
//        query = "SELECT o.*, u.* FROM organizations o left join users u on o.id = u.organizationId and o.parentId = ?",
//            resultSetMapping = "organizationResult"),

    @NamedNativeQuery(name="findChildrenByParentId",
        query = "SELECT o.* FROM organizations o where o.parentId = ?",
            resultClass = Organization.class),

    @NamedNativeQuery(name="findAllOrganizations",
            query = "select * from organizations", resultClass = Organization.class)
})
@SqlResultSetMapping(name = "organizationResult", entities = {
        @EntityResult(entityClass = Organization.class),
        @EntityResult(entityClass = User.class)})
public class Organization {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Column
    private Integer priority;

    @Column(nullable = false)
    private Long parentId;

    @Column(length = 100, nullable = false)
    private String parentIds;

    @Column(nullable = false)
    private Boolean enabled;

    @OneToMany(mappedBy = "organization")
    private Set<User> users;

    public Organization(){}

    public Organization(String name, Integer priority, Long parentId, String parentIds, Boolean enabled,
                        Set<User> users) {
        this.name = name;
        this.priority = priority;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.enabled = enabled;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
