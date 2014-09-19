package com.pact.identity.infrastructure.persistence.repositories;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.domain.repositories.IOrganizationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Bright Huang on 8/7/14.
 */
@Repository("OrganizationRepository")
@Transactional
public class OrganizationRepository implements IOrganizationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createOrganization(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void saveOrganization(Organization organization) {

        em.merge(organization);
    }

    @Override
    public void removeOrganization(Organization organization) {
        em.remove(organization);
    }

    @Override
    public Organization findOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public List<Organization> findAllOrganizations() {
        return em.createNamedQuery("findAllOrganizations").getResultList();
    }

    @Override
    public List<Organization> findChildrenByParentId(Long parentId) {
        return em.createNamedQuery("findChildrenByParentId").setParameter(1, parentId).getResultList();
    }
}
