package com.elibmanager.dao.impl;

import com.elibmanager.dao.ApplyDao;
import com.elibmanager.model.Apply;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mengchenyun on 2016/8/8.
 */
@Repository
@Transactional
public class ApplyDaoImpl implements ApplyDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Apply getApplyById(int applyId) {
        Session session = sessionFactory.getCurrentSession();
        return (Apply) session.get(Apply.class, applyId);
    }
}
