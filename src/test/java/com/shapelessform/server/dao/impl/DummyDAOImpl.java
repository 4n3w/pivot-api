package com.shapelessform.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.shapelessform.server.dao.DummyDAO;
import com.shapelessform.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.shapelessform.server.dao.impl.GenericHibernateDAOImpl} methods
 */
@Repository
public class DummyDAOImpl extends GenericHibernateDAOImpl<DummyEntity, Long> implements DummyDAO {
    
}
