package com.elibmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */

@Entity
public class Student implements Serializable{

    private static final long serialVersionUID = 1773667694717719850L;

    @Id
    @GeneratedValue
    private int studentId;

    @NotEmpty(message = "The student name must not be null.")
    private String studentName;

    @NotEmpty(message = "The student email must not be null.")
    private String studentEmail;

    @NotEmpty(message = "The student username must not be null.")
    private String username;

    @NotEmpty(message = "The student password must not be null.")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "applyId")
    @JsonIgnore
    private Apply apply;

    @OneToMany(mappedBy = "student", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Book> bookList;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
