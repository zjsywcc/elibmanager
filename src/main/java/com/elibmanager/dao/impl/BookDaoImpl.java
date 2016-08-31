package com.elibmanager.dao.impl;

import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wcc on 2016/8/5.
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void indexBooks() throws Exception
    {
        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        fullTextSession.createIndexer(Book.class).start();

    }

    public List<Book> searchForBook(String searchText) throws Exception
    {
        List<Book> results = null;

        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(Book.class).get();
        org.apache.lucene.search.Query query = qb
                .phrase().onField("bookName")
                .andField("bookAuthor")
                .andField("bookPress")
                .andField("bookISBN")
                .andField("bookOwner")
                .sentence(searchText)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, Book.class);

        results = hibQuery.list();
        return results;

    }

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
        session.flush();
    }

    public void addAllBooks(List<Book> books) {
        Session session = sessionFactory.getCurrentSession();
        for(Book book : books) {
            session.saveOrUpdate(book);
        }
        session.flush();
    }

    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);
        session.flush();
        return book;
    }

    public List<Book> getAllBooksOnShelf() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where bookStatus = ?");
        query.setString(0, "onShelf");
        List<Book> books = query.list();
        session.flush();
        return books;
    }

    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book");
        List<Book> books = query.list();
        session.flush();
        return books;
    }

    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
        session.flush();
    }

    public void deleteBook(int id) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(getBookById(id));
        session.flush();
    }

    public void removeBooksByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = studentDao.getStudentById(studentId).getBookList();
        for(Book book : books) {
            deleteBook(book.getBookId());
        }
    }
}
