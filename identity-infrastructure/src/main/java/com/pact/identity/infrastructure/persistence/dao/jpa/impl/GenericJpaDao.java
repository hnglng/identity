package com.pact.identity.infrastructure.persistence.dao.jpa.impl;

import com.pact.identity.infrastructure.persistence.dao.jpa.IGenericDao;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GenericJpaDao<T> implements IGenericDao<T> {
	protected Class<T> clazz;
	protected EntityManager entityManager;

	TransactionTemplate template;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {

        entityManager = emf.createEntityManager();
	}

	public GenericJpaDao(Class<T> clazz) {
		this.clazz = clazz;
	}

    /**
     * @param t
     * @return
     */
    @Transactional
    public boolean add(final T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            flush();
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

	/**
	 * @param t
	 * @return
	 */
	@Transactional
	public boolean save(final T t) {
		try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
			flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Transactional
	public boolean deleteById(Object id) {
		if (id == null)
			throw new java.lang.IllegalArgumentException("id not exists");
		T object = this.findById(id);
		if (object != null) {
			try {

                entityManager.remove(object);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * @param t
	 * @return
	 */

	/**
	 * @param t
	 * @return
	 */
	@Transactional
	public boolean update(T t) {
		if (t != null) {
            entityManager.merge(t);
			return true;
		}
		return false;
	}

	@Override
	public int batchUpdate(final String jpql, final Object[] params) {
		Query query = entityManager.createQuery(jpql);
		int parameterIndex = 1;
		if (params != null && params.length > 0) {
			for (Object obj : params) {
				query.setParameter(parameterIndex++, obj);
			}
		}
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = entityManager.createQuery("select t from " + clazz.getName() + " t");
		return query.getResultList();
	}

	public T findById(Object id) {
		if (id != null) {
			return entityManager.find(clazz, id);
		}
		return null;

	}

	@Override
	public List<T> getBy(final String propertyName, final Object value) {
		List<String> propertyNames = new ArrayList<String>();
		propertyNames.add(propertyName);
		List<Object> values = new ArrayList<Object>();
		values.add(value);
		return getBy(propertyNames, values);

	}

	@Override
	public T getFirstRecord(final String propertyName, final Object value) {
		List<T> results = getBy(propertyName, value);
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBy(final List<String> propertyNames, final List<Object> values) {
		String clazzName = clazz.getSimpleName();
		StringBuffer stringBuffer = new StringBuffer("select obj from ");
		stringBuffer.append(clazzName).append(" obj");
		Query query = null;
		String propertyName = "";
		Object value = null;

		for (int i = 0; i < propertyNames.size(); i++) {
			propertyName = propertyNames.get(i);
			value = values.get(i);
			if (propertyName != null && value != null) {
				if (i == 0) {
					stringBuffer.append(" where ");
				} else {
					stringBuffer.append(" and ");
				}
				stringBuffer.append(" obj.").append(propertyName)
						.append("='" + value + "'");

			}
		}

		System.out.println("sql:" + stringBuffer.toString());
		query = entityManager.createQuery(stringBuffer.toString());

		return query.getResultList();

	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> find(final String hql, final Object[] params,
			final int begin, final int max) {

		Query query = entityManager.createQuery(hql);
		int parameterIndex = 1;
		if (params != null && params.length > 0) {
			for (Object obj : params) {
				query.setParameter(parameterIndex++, obj);
			}
		}

		if (begin >= 0 && max > 0) {
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}

		List list = query.getResultList();
		if (list != null && list.size() >= 0) {
			return list;
		} else {
			return new ArrayList<T>();
		}
	}

	public void flush() {
        entityManager.getTransaction().commit();
	}

	@Override
	public T getFirstRecord(List<String> propertyNames, List<Object> values) {
		List<T> results = getBy(propertyNames, values);
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}
}
