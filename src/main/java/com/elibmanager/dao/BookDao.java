package com.elibmanager.dao;

import com.elibmanager.model.Book;

import java.util.List;

/**
 * Created by wcc on 2016/8/5.
 */
public interface BookDao {

    void addBook(Book book);

    void addAllBooks(List<Book> book);

    Book getBookById(int id);

    List<Book> getAllBooks();

    List<Book> getAllBooksOnShelf();

    void deleteBook(int id);

    void editBook(Book book);

    void removeBooksByStudentId(int studentId);
}
