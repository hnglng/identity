package com.pact.identity.domain.repositories;

import com.pact.identity.domain.entities.Organization;

import java.util.List;

/**
 * Created by apple on 7/29/14.
 */
public interface IOrganizationRepository {

    public void createOrganization(Organization organization);
    public void saveOrganization(Organization organization) ;
    public void removeOrganization(Organization organization) ;

    public Organization findOrganizationById(Long id);
    public List<Organization> findAllOrganizations();
    public List<Organization> findChildrenByParentId(Long parentId);
}
