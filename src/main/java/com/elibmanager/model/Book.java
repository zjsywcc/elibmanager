package com.elibmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;


/**
 * Created by wcc on 2016/8/4.
 */
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = -6251070844531027911L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @NotEmpty(message = "The book name must not be null.")
    private String bookName;
    private String bookAuthor;
    private String bookPress;

    @Min(value = 0, message = "The book price must not be less than zero.")
    private double bookPrice;
    private String bookEdition;
    private String bookISBN;
    private String bookOwner;

    @Transient
    private MultipartFile bookImage;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ApplyItem> applyItemList;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    private String bookStatus;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookOwner() {
        return bookOwner;
    }

    public void setBookOwner(String bookOwner) {
        this.bookOwner = bookOwner;
    }

    public MultipartFile getBookImage() {
        return bookImage;
    }

    public void setBookImage(MultipartFile bookImage) {
        this.bookImage = bookImage;
    }

    public List<ApplyItem> getApplyItemList() {
        return applyItemList;
    }

    public void setApplyItemList(List<ApplyItem> applyItemList) {
        this.applyItemList = applyItemList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
