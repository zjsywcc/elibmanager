package com.elibmanager.dao;

import com.elibmanager.model.Book;

import java.util.List;

/**
 * Created by wcc on 2016/8/5.
 */
public interface BookDao {

    void addBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();

    void deleteBook(int id);

    void editBook(Book book);
}
