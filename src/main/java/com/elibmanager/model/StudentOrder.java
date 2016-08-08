package com.elibmanager.model;

import javax.persistence.*;
import java.io.Serializable;

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
}
