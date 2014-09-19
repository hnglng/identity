package com.pact.identity.application.service;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.domain.repositories.IOrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 7/29/14.
 */
@Component
@Transactional
public class OrganizationService {

    @Autowired
    private IOrganizationRepository organizationRepository;


    public void createOrganization(Organization organization){

        organizationRepository.createOrganization(organization);
    }


    public Organization getOrganizationById(Long id) {

        return organizationRepository.findOrganizationById(id);
    }

    public void saveOrganization(Organization organization) {

        organizationRepository.saveOrganization(organization);
    }


    public void removeOrganization(Organization organization) {

        organizationRepository.removeOrganization(organization);
    }

    public List<Organization> allOfOrganization()
    {
        return organizationRepository.findAllOrganizations();
    }

    public List<Organization> findChildrenByParentId(Long parentId){
        return organizationRepository.findChildrenByParentId(parentId);
    }

}
