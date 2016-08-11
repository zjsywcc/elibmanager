package com.elibmanager.dao.impl;

import com.elibmanager.dao.UsersDao;
import com.elibmanager.model.Users;
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
public class UsersDaoImpl implements UsersDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addUsers(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(users);
        session.flush();
    }

    public void editUsers(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(users);
        session.flush();
    }

    public void deleteUsers(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(users);
        session.flush();
    }

    public Users getUsersByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where studentId = ?");
        query.setInteger(0, studentId);
        Users users = (Users) query.uniqueResult();
        return users;
    }

    public void deleteUsersByStudentId(int studentId) {
        deleteUsers(getUsersByStudentId(studentId));
    }
}
