package com.pact.identity.presentation.helper;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.presentation.model.OrganizationModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bright Huang on 8/6/14.
 */
@Component
public class OrganizationHelper implements IHelper<OrganizationModel, Organization> {
    @Override
    public OrganizationModel toModel(Organization entity) {

        OrganizationModel organizationModel = new OrganizationModel();

        organizationModel.setId(entity.getId());
        organizationModel.setName(entity.getName());
        organizationModel.setEnabled(entity.getEnabled());
        organizationModel.setParentId(entity.getParentId());
        organizationModel.setParentIds(entity.getParentIds());
        organizationModel.setPriority(entity.getPriority());

        return organizationModel;
    }

    @Override
    public Organization toEntity(OrganizationModel model) {

        Organization organization = new Organization();

        organization.setId(model.getId());
        organization.setName(model.getName());
        organization.setEnabled(model.getEnabled());
        organization.setParentId(model.getParentId());
        organization.setParentIds(model.getParentIds());
        organization.setPriority(model.getPriority());

        return organization;
    }

    public List<OrganizationModel> toModels(List<Organization> organizationList){

        List<OrganizationModel> organizationModels = new ArrayList<OrganizationModel>();

        for (Organization organization : organizationList){
            organizationModels.add(toModel(organization));
        }

        return organizationModels;
    }
}
