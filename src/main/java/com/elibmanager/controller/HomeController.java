package com.elibmanager.controller;

import com.elibmanager.dao.BookDao;
import com.elibmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wcc on 2016/8/4.
 */
@Controller
public class HomeController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping("/")
    public String Home() {
        return "index";
    }

    @RequestMapping("/bookList")
    public String BookList(Model model) {
        List<Book> books = bookDao.getAllBooks();
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping("/bookList/viewBook/{bookId}")
    public String viewBook(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookDao.getBookById(bookId);
        model.addAttribute("book", book);
        return "viewBook";
    }
}
