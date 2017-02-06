package com.elibmanager.dao;

import com.elibmanager.model.BookInfo;

import java.util.List;

/**
 * Created by mengchenyun on 2016/08/29.
 */
public interface BookInfoDao {

    void indexBooks() throws Exception;

    List<BookInfo> searchForBook(String searchText) throws Exception;

    BookInfo getBookInfoById(int id);
}
