package com.elibmanager.dao.impl;

import com.elibmanager.dao.ApplyItemDao;
import com.elibmanager.model.Apply;
import com.elibmanager.model.ApplyItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void removeApplyItem(ApplyItem applyItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(applyItem);
        session.flush();
    }

    public void removeAllApplyItems(Apply apply) {
        List<ApplyItem> applyItems = apply.getApplyItems();

        for(ApplyItem item : applyItems) {
            removeApplyItem(item);
        }
    }

    public ApplyItem getApplyItemByBookId (int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ApplyItem where bookId = ?");
        query.setInteger(0, bookId);
        session.flush();

        return (ApplyItem) query.uniqueResult();
    }
}
