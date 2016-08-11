package com.elibmanager.dao.impl;

import com.elibmanager.dao.StudentDao;
import com.elibmanager.dao.StudentOrderDao;
import com.elibmanager.model.StudentOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wcc on 2016/8/10.
 */
@Repository
@Transactional
public class StudentOrderDaoImpl implements StudentOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private StudentDao studentDao;

    public void addStudentOrder(StudentOrder studentOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(studentOrder);
        session.flush();
    }

    public void deleteStudentOrder(StudentOrder studentOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(studentOrder);
        session.flush();
    }

    public List<StudentOrder> getStudentOrderByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from StudentOrder where student = ?");
        query.setEntity(0, studentDao.getStudentById(studentId));
        List<StudentOrder> studentOrders = query.list();

        return studentOrders;
    }

    public void removeAllStudentOrders(int studentId) {
        List<StudentOrder> studentOrders = getStudentOrderByStudentId(studentId);
        for(StudentOrder studentOrder : studentOrders) {
            deleteStudentOrder(studentOrder);
        }
    }
}
