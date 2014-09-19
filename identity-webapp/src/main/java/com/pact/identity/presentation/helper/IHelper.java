package com.pact.identity.presentation.helper;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.presentation.model.OrganizationModel;

import java.util.List;

/**
 * Created by Bright Huang on 8/6/14.
 */
public interface IHelper<M, E> {

    public M toModel(E entity);
    public E toEntity(M model);


}
