package com.elibmanager.controller;

import com.elibmanager.dao.BookDao;
import com.elibmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by wcc on 2016/8/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping
    public String admin() {
//        String currentUser = null;
//        try {
//            currentUser = principal.getName();
//        } catch (Exception e) {
//            throw new RuntimeException("cannot fetch user info: ", e);
//        }
//        if(currentUser != null) {
//            model.addAttribute("currentUser", currentUser);
//        }
        return "admin";
    }

    @RequestMapping("/bookInventory")
    public String bookInventory(Model model) {
        List<Book> books = bookDao.getAllBooks();
        model.addAttribute("books", books);
        return "bookInventory";
    }

    @RequestMapping("/bookInventory/addBook")
    public String addBook() {
        return "addBook";
    }

    @RequestMapping(value = "/bookInventory/addBook", method = RequestMethod.POST)
    public String addBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "addBook";
        }
        bookDao.addBook(book);
        return "redirect:/admin/bookInventory";
    }

}
