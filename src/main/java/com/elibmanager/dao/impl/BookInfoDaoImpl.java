package com.elibmanager.dao.impl;

import com.elibmanager.dao.BookInfoDao;
import com.elibmanager.model.BookInfo;
import org.hibernate.HibernateException;
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
 * Created by mengchenyun on 2016/08/29.
 */
@Repository
@Transactional
public class BookInfoDaoImpl implements BookInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void indexBooks() throws Exception
    {
        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        fullTextSession.createIndexer(BookInfo.class).start();

    }

    public List<BookInfo> searchForBook(String searchText) throws Exception
    {
        List<BookInfo> results = null;

        Session session = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(BookInfo.class).get();
        org.apache.lucene.search.Query query = qb
                .phrase().onField("bookName")
                .andField("bookAuthor")
                .andField("bookPress")
                .andField("bookISBN")
                .sentence(searchText)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, BookInfo.class);

        results = hibQuery.list();
        return results;

    }

    public BookInfo getBookInfoById(int id) {
        Session session = sessionFactory.getCurrentSession();
        BookInfo bookInfo = (BookInfo) session.get(BookInfo.class, id);
        session.flush();
        return bookInfo;
    }

}
