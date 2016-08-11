package com.elibmanager.dao;

import com.elibmanager.model.Users;

/**
 * Created by wcc on 2016/8/11.
 */
public interface UsersDao {

    void addUsers(Users users);

    void editUsers(Users users);

    void deleteUsers(Users users);

    Users getUsersByStudentId(int studentId);

    void deleteUsersByStudentId(int studentId);
}
