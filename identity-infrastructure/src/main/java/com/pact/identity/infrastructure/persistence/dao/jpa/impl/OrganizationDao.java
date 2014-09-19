package com.pact.identity.infrastructure.persistence.dao.jpa.impl;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.infrastructure.persistence.dao.jpa.IOrganizationDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Bright Huang on 8/1/14.
 */
@Repository("OrganizationDao")
@Transactional
public class OrganizationDao implements IOrganizationDao{
    private static final String USERS_FOR_ORGANIZATION =
            "SELECT * FROM User a WHERE a.orgnization_id = :organization_id ";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addOrganization(Organization organization) {
        em.persist(organization);
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void saveOrganization(Organization organization) {

        em.merge(organization);

    }

    @Override
    public void removeOrganization(Organization organization) {
        em.remove(organization);
    }

    public List<Organization> allOfOrganization(){
        Query query = em.createQuery("select t from Organization t");
        return query.getResultList();
    }
}
