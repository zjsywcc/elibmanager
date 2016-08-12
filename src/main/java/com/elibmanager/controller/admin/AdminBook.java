package com.elibmanager.controller.admin;

import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Book;
import com.elibmanager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wcc on 2016/8/10.
 */

@Controller
@RequestMapping("/admin")
public class AdminBook {

    private Path path;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private StudentDao studentDao;


    @RequestMapping("/bookInventory/addBook")
    public String addBook(Model model) {
        initMap(model);
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @RequestMapping(value = "/bookInventory/addBook", method = RequestMethod.POST)
    public String addBookPost(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request, Model model) {
        initMap(model);
        if (result.hasErrors()) {
            return "addBook";
        }

        String owner = book.getBookOwner();
        if (owner != null && !owner.isEmpty()) {
            Student student = studentDao.getStudentByStudentName(owner);
            if (student != null) {
                book.setStudent(student);
            }
        }
        bookDao.addBook(book);

        MultipartFile bookImage = book.getBookImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + book.getBookId() + ".png");

        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Book image saving failed", e);
            }
        }
        return "redirect:/admin/bookInventory";
    }

    @RequestMapping("/bookInventory/editBook/{bookId}")
    public String editBook(@PathVariable("bookId") int bookId, Model model) {
        initMap(model);
        Book book = bookDao.getBookById(bookId);
        model.addAttribute(book);
        return "editBook";
    }

    @RequestMapping(value = "/bookInventory/editBook", method = RequestMethod.POST)
    //BindingResult should just follow the @ModelAttribute!
    public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request, Model model) {
        initMap(model);
        if (result.hasErrors()) {
            return "editBook";
        }
        MultipartFile bookImage = book.getBookImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + book.getBookId() + ".png");

        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Book image saving failed", e);
            }
        }

        String owner = book.getBookOwner();
        if (owner != null && !owner.isEmpty()) {
            Student student = studentDao.getStudentByUsername(owner);
            if (student != null) {
                book.setStudent(student);
            }
        }
        bookDao.editBook(book);

        return "redirect:/admin/bookInventory";
    }

    @RequestMapping("/bookInventory/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + bookId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        bookDao.deleteBook(bookId);
        return "redirect:/admin/bookInventory";
    }

    // just pass map to radiobuttons in ftl
    public void initMap(Model model) {
        Map status = new LinkedHashMap();
        status.put("onShelf", "onShelf");
        status.put("checking", "checking");
        model.addAttribute("status", status);
    }

}

