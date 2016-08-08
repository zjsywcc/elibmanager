package com.elibmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */

@Entity
public class Apply implements Serializable {

    private static final long serialVersionUID = 4948740150252264386L;

    @Id
    @GeneratedValue
    private int applyId;

    @OneToMany(mappedBy = "apply", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ApplyItem> applyItems;

    @OneToOne
    @JoinColumn(name = "studentId")
    @JsonIgnore
    private Student student;

    private double grandTotal;

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public List<ApplyItem> getApplyItems() {
        return applyItems;
    }

    public void setApplyItems(List<ApplyItem> applyItems) {
        this.applyItems = applyItems;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
