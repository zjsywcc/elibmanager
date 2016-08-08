package com.elibmanager.dao.impl;

import com.elibmanager.dao.ApplyItemDao;
import com.elibmanager.model.ApplyItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wcc on 2016/8/8.
 */
@Repository
@Transactional
public class ApplyItemDaoImpl implements ApplyItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addApplyItem(ApplyItem applyItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(applyItem);
        session.flush();
    }
}
