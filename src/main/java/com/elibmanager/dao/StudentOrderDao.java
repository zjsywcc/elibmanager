package com.elibmanager.dao;

import com.elibmanager.model.StudentOrder;

import java.util.List;

/**
 * Created by wcc on 2016/8/10.
 */
public interface StudentOrderDao {

    void addStudentOrder(StudentOrder studentOrder);

    void deleteStudentOrder(StudentOrder studentOrder);

    List<StudentOrder> getStudentOrderByStudentId(int studentId);

    void removeAllStudentOrders(int studentId);

    StudentOrder getStudentOrderById(int studentOrderId);
}
