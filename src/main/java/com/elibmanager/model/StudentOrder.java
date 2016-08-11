package com.elibmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */

@Entity
public class StudentOrder implements Serializable {

    private static final long serialVersionUID = -641297149924869095L;

    @Id
    @GeneratedValue
    private int studentOrderId;

    @OneToOne
    @JoinColumn(name = "applyId")
    private Apply apply;

    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @OneToMany(mappedBy = "studentOrder", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Book> bookList;


    public int getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(int studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
