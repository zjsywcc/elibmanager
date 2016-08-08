package com.elibmanager.dao.impl;

import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Apply;
import com.elibmanager.model.Authorities;
import com.elibmanager.model.Student;
import com.elibmanager.model.Users;
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
}
