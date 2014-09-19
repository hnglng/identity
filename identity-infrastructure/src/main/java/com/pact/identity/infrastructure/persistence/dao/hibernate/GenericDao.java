package com.pact.identity.infrastructure.persistence.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by apple on 7/29/14.
 */
public class GenericDao<T> implements IGenericDao<T> {

//    @Autowired
//    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    protected Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean save(T t) {
        return false;
    }

    @Override
    public boolean deleteById(Object id) {
        return false;
    }

    @Override
    public boolean update(T t) {
        return false;
    }

    @Override
    public int batchUpdate(String jpql, Object[] params) {
        return 0;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Object id) {
        return null;
    }

    @Override
    public List<T> getBy(String propertyName, Object value) {
        return null;
    }

    @Override
    public T getFirstRecord(String propertyName, Object value) {
        return null;
    }

    @Override
    public List<T> getBy(List<String> propertyNames, List<Object> values) {
        return null;
    }

    @Override
    public T getFirstRecord(List<String> propertyNames, List<Object> values) {
        return null;
    }

    @Override
    public List<T> find(String hql, Object[] params, int begin, int max) {
        return null;
    }
}
