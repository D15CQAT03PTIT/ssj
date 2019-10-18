package com.tbl.ssj.Untils;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BaseHibernateDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession() {
        return (Session) entityManager.getDelegate();
    }
}
