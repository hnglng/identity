package com.pact.identity.domain.mytest;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 7/17/14.
 */
public class JPASessionUtil {
    static Map<String, EntityManagerFactory> persistenceUnits = new HashMap<String, EntityManagerFactory>();

    /**
     Returns a JPA EntityManager given a valid persistence unit name.
     */
    public static synchronized EntityManager getEntityManager(String persistenceUnitName) {
        // have we already created this factory? If not, create it and save it.
        if (persistenceUnits.get(persistenceUnitName) == null) {
            persistenceUnits.put(persistenceUnitName,
                    Persistence.createEntityManagerFactory(persistenceUnitName));
        }
        return persistenceUnits.get(persistenceUnitName)
                .createEntityManager();
    }

    /**
     Persistence unit.
     */
    public static Session getSession(String persistenceUnitName) {
        return getEntityManager(persistenceUnitName).unwrap(Session.class);
    }
}
