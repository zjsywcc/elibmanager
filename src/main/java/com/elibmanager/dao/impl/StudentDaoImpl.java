package com.elibmanager.dao.impl;

import com.elibmanager.dao.*;
import com.elibmanager.model.*;
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
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private AuthoritiesDao authoritiesDao;

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private StudentOrderDao studentOrderDao;

    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(student);

        Users newUser = new Users();
        newUser.setUsername(student.getUsername());
        newUser.setPassword(student.getPassword());
        newUser.setEnabled(true);
        newUser.setStudentId(student.getStudentId());

        Authorities authorities = new Authorities();
        authorities.setUsername(student.getUsername());
        authorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(authorities);

        Apply apply = new Apply();
        apply.setStudent(student);
        student.setApply(apply);
        session.saveOrUpdate(student);
        session.saveOrUpdate(apply);

        session.flush();
    }

    public Student getStudentById(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        return (Student) session.get(Student.class, studentId);
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();

        return students;
    }

    public Student getStudentByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student where username = ?");
        query.setString(0, username);

        return (Student) query.uniqueResult();
    }

    public void editStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();

        int studentId = student.getStudentId();
        Users users = usersDao.getUsersByStudentId(studentId);
        String username = users.getUsername();

        users.setEnabled(student.isEnabled());
        users.setUsername(student.getUsername());
        users.setPassword(student.getPassword());
        session.saveOrUpdate(users);

        Authorities authorities = authoritiesDao.getAuthoritiesByUsername(username);
        authorities.setUsername(student.getUsername());
        session.saveOrUpdate(authorities);

        Apply apply = student.getApply();
        student.setApply(apply);

        session.saveOrUpdate(student);
        session.flush();
    }

    public void deleteStudent(int studentId) {
        Session session = sessionFactory.getCurrentSession();

        Student student = getStudentById(studentId);

        Users users = usersDao.getUsersByStudentId(studentId);
        String username = users.getUsername();
        usersDao.deleteUsers(users);

        authoritiesDao.deleteAuthoritiesByUsername(username);

        Apply apply = applyDao.getApplyById(student.getApply().getApplyId());
        applyItemDao.removeAllApplyItems(apply);
        session.delete(apply);

        List<StudentOrder> studentOrders = studentOrderDao.getStudentOrderByStudentId(studentId);
        for(StudentOrder studentOrder : studentOrders) {
            session.delete(studentOrder);
        }

        List<Book> books = student.getBookList();
        for(Book book : books) {
            session.delete(book);
        }

        session.delete(student);
        session.flush();
    }
}
