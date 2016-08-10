package com.elibmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcc on 2016/8/9.
 */
public class BookListWrapper {

    private List<Book> bookList;

    public BookListWrapper() {
        this.bookList = new ArrayList<Book>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void add(Book book) {
        this.bookList.add(book);
    }
}
