package com.elibmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wcc on 2016/8/8.
 */

@Entity
public class ApplyItem implements Serializable{

    private static final long serialVersionUID = 718890758036445325L;

    @Id
    @GeneratedValue
    private int applyItemId;

    @ManyToOne
    @JoinColumn(name = "applyId")
    @JsonIgnore
    private Apply apply;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    private int quantity;
    private double totalPrice;

    public int getApplyItemId() {
        return applyItemId;
    }

    public void setApplyItemId(int applyItemId) {
        this.applyItemId = applyItemId;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
