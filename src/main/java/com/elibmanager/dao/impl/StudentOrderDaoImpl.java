package com.elibmanager.dao.impl;

import com.elibmanager.dao.StudentOrderDao;
import com.elibmanager.model.StudentOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wcc on 2016/8/10.
 */
@Repository
@Transactional
public class StudentOrderDaoImpl implements StudentOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStudentOrder(StudentOrder studentOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(studentOrder);
        session.flush();
    }
}
