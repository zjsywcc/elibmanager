package com.elibmanager.dao.impl;

import com.elibmanager.dao.AuthoritiesDao;
import com.elibmanager.model.Authorities;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wcc on 2016/8/11.
 */
@Repository
@Transactional
public class AuthoritiesDaoImpl implements AuthoritiesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addAuthorities(Authorities authorities) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authorities);
        session.flush();
    }

    public void editAuthorities(Authorities authorities) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authorities);
        session.flush();
    }

    public void deleteAuthorities(Authorities authorities) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(authorities);
        session.flush();
    }

    public Authorities getAuthoritiesByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Authorities where username = ?");
        query.setString(0, username);
        Authorities authorities = (Authorities) query.uniqueResult();
        return authorities;
    }

    public void deleteAuthoritiesByUsername(String username) {
        deleteAuthorities(getAuthoritiesByUsername(username));
    }
}
