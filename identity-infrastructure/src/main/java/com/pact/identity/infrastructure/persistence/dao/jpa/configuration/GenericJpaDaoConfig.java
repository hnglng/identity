package com.pact.identity.infrastructure.persistence.dao.jpa.configuration;

import com.pact.identity.domain.entities.Organization;
import com.pact.identity.domain.entities.Resource;
import com.pact.identity.domain.entities.User;
import com.pact.identity.infrastructure.persistence.dao.jpa.impl.GenericJpaDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericJpaDaoConfig {

    @Bean
    public GenericJpaDao<User> getUserDao() {
        return new GenericJpaDao<User>(User.class);
    }

    @Bean
    public GenericJpaDao<Organization> getOrganizationDao() {
        return new GenericJpaDao<Organization>(Organization.class);
    }

    @Bean
    public GenericJpaDao<Resource> getResourceDao() {
        return new GenericJpaDao<Resource>(Resource.class);
    }


}
