package com.pact.identity.domain.mytest;

import org.hibernate.Session;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.fail;

/**
 * Created by apple on 7/17/14.
 */
public class JPASessionUtilTest {
    @Test
    public void getEntityManager() {
        EntityManager em = JPASessionUtil.getEntityManager("utiljpa");
        em.close();
    }
    @Test(expectedExceptions = {javax.persistence.PersistenceException.class})
    public void nonexistentEntityManagerName() {
        JPASessionUtil.getEntityManager("nonexistent");
        fail("We shouldn't be able to acquire an EntityManager here");
    }
    @Test
    public void getSession() {
        Session session = JPASessionUtil.getSession("utiljpa");
        session.close();
    }
    @Test(expectedExceptions = {javax.persistence.PersistenceException.class})
    public void nonexistentSessionName() {
        JPASessionUtil.getSession("nonexistent");
        fail("We shouldn't be able to acquire a Session here");


    }
}
