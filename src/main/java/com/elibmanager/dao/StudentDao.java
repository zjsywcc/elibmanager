package com.elibmanager.dao;

import com.elibmanager.model.Student;

import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */
public interface StudentDao {

    void addStudent(Student student);

    Student getStudentById(int studentId);

    List<Student> getAllStudents();

    Student getStudentByUsername(String username);

    Student getStudentByStudentName(String studentName);

    void editStudent(Student student);

    void deleteStudent(int studentId);
}
