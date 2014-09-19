package com.pact.identity.infrastructure.persistence.dao.jpa;

import com.pact.identity.domain.entities.Organization;

import java.util.List;

/**
 * Created by Bright Huang on 8/1/14.
 */
public interface IOrganizationDao {
    public void addOrganization(Organization organization);
    public Organization getOrganizationById(Long id);
    public void saveOrganization(Organization organization);
    public void removeOrganization(Organization organization);
    public List<Organization> allOfOrganization();

}
