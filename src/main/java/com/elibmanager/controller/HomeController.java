package com.elibmanager.controller;

import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.BookInfoDao;

import com.elibmanager.model.Book;
import com.elibmanager.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wcc on 2016/8/4.
 */
@Controller
public class HomeController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookInfoDao bookInfoDao;

    @RequestMapping("/")
    public String Home() throws Exception {
        bookInfoDao.indexBooks();
        return "index";
    }

    @RequestMapping("/bookList")
    public String BookList(Model model) {
        List<Book> books = bookDao.getAllBooksOnShelf();
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping("/bookList/viewBook/{bookId}")
    public String viewBook(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookDao.getBookById(bookId);
        model.addAttribute("book", book);
        return "viewBook";
    }

    @RequestMapping("/search")
    public String search() {
        return "searchResult";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value = "searchText", required = false) String searchText, Model model) throws Exception{
        if(searchText == null || searchText.isEmpty()) {
            model.addAttribute("msg", "请求参数为空");
            return "searchResult";
        }
        List<Book> allFound = bookDao.searchForBook(searchText);
        model.addAttribute("allFoundBooks", allFound);
        return "searchResult";
    }


    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooks(@RequestParam String searchText) throws Exception {
        return bookDao.searchForBook(searchText);
    }
}
