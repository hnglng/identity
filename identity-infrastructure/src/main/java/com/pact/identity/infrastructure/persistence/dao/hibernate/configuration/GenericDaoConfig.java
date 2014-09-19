package com.pact.identity.infrastructure.persistence.dao.hibernate.configuration;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.domain.entities.Resource;
import com.pact.identity.domain.entities.User;
import com.pact.identity.infrastructure.persistence.dao.hibernate.GenericDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by apple on 7/29/14.
 */
@Configuration
public class GenericDaoConfig {

    @Bean
    public GenericDao<Organization> organizationGenericDao() {
        return new GenericDao<Organization>(Organization.class);
    }

    @Bean
    public GenericDao<User> userGenericDao() {

        return new GenericDao<User>(User.class);
    }

    @Bean
    public GenericDao<Resource> resourceGenericDao() {

        return new GenericDao<Resource>(Resource.class);
    }
}
