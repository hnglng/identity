package com.pact.identity.infrastructure.persistence.dao.hibernate;

import java.util.List;

/**
 * Created by apple on 7/29/14.
 */
public interface IGenericDao<T>  {
    boolean add(final T t);

    boolean save(final T t);

    boolean deleteById(final Object id);

    boolean update(final T t);

    int batchUpdate(final String jpql, final Object[] params);

    List<T> findAll();

    T findById(final Object id);

    List<T> getBy(final String propertyName, final Object value);

    T getFirstRecord(final String propertyName, final Object value);

    List<T> getBy(final List<String> propertyNames, final List<Object> values);

    T getFirstRecord(final List<String> propertyNames, final List<Object> values);

    List<T> find(final String hql, final Object[] params, final int begin, final int max);
}
