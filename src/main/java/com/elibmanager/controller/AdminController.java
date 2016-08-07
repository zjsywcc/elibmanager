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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by wcc on 2016/8/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Path path;

    @Autowired
    private BookDao bookDao;

    @RequestMapping
    public String admin() {
        return "admin";
    }

    @RequestMapping("/bookInventory")
    public String bookInventory(Model model) {
        List<Book> books = bookDao.getAllBooks();
        model.addAttribute("books", books);
        return "bookInventory";
    }

    @RequestMapping("/bookInventory/addBook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @RequestMapping(value = "/bookInventory/addBook", method = RequestMethod.POST)
    public String addBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "addBook";
        }
        bookDao.addBook(book);

        MultipartFile bookImage = book.getBookImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + book.getBookId() + ".png");

        if(bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Book image saving failed", e);
            }
        }
        return "redirect:/admin/bookInventory";
    }

}
