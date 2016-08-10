package com.elibmanager.controller.admin;

import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Book;
import com.elibmanager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wcc on 2016/8/10.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private StudentDao studentDao;

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

    @RequestMapping("/students")
    public String studentsManagement(Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "studentsManagement";
    }

}
