package com.shapelessform.server.dao;

import com.shapelessform.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.shapelessform.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
