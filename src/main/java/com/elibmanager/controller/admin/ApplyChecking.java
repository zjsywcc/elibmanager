package com.elibmanager.controller.admin;

import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentOrderDao;
import com.elibmanager.model.Book;
import com.elibmanager.model.StudentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by wcc on 2016/8/11.
 */
@Controller
@RequestMapping("/admin/students/bookApply")
public class ApplyChecking {

    @Autowired
    private StudentOrderDao studentOrderDao;

    @Autowired
    private BookDao bookDao;

    @RequestMapping("/{studentId}")
    public String checkApply(@PathVariable("studentId") int studentId, Model model) {
        List<StudentOrder> studentOrders = studentOrderDao.getStudentOrderByStudentId(studentId);
        model.addAttribute("studentOrders", studentOrders);
        model.addAttribute("studentId", studentId);
        return "applyChecking";
    }

    @RequestMapping("/checkBook/{bookId}")
    public String checkBook(@PathVariable("bookId") int bookId) {
        Book book = bookDao.getBookById(bookId);
        int studentId = book.getStudent().getStudentId();
        book.setBookStatus("onShelf");
        bookDao.editBook(book);
        return "redirect:/admin/students/bookApply/"+studentId;
    }

    @RequestMapping("/checkBook")
    public String checkBookForAll(@RequestParam(value = "order", required = false) Integer order,
                            @RequestParam(value = "student", required = false) Integer student) {
        int studentId = 0;
        if(order != null) {
            StudentOrder studentOrder = studentOrderDao.getStudentOrderById(order);
            studentId = studentOrder.getStudent().getStudentId();
            List<Book> books = studentOrder.getBookList();
            for(Book book : books) {
                book.setBookStatus("onShelf");
                bookDao.editBook(book);
            }
        }
        if(student != null) {
            studentId = student;
            List<StudentOrder> studentOrders = studentOrderDao.getStudentOrderByStudentId(studentId);
            for(StudentOrder studentOrder : studentOrders) {
                List<Book> books = studentOrder.getBookList();
                for(Book book : books) {
                    book.setBookStatus("onShelf");
                    bookDao.editBook(book);
                }
            }
        }
        return "redirect:/admin/students/bookApply/"+studentId;
    }

    @RequestMapping("/deleteApply/{bookId}")
    public String deleteApply(@PathVariable("bookId") int bookId) {
        Book book = bookDao.getBookById(bookId);
        int studentId = book.getStudent().getStudentId();
        bookDao.deleteBook(bookId);
        return "redirect:/admin/students/bookApply/"+studentId;
    }

    @RequestMapping("/deleteApply")
    public String deleteApplyForAll(@RequestParam(value = "order", required = false) Integer order,
                            @RequestParam(value = "student", required = false) Integer student) {
        int studentId = 0;
        if(order != null) {
            StudentOrder studentOrder = studentOrderDao.getStudentOrderById(order);
            studentId = studentOrder.getStudent().getStudentId();
            List<Book> books = studentOrder.getBookList();
            for(Book book : books) {
                bookDao.deleteBook(book.getBookId());
            }
            studentOrderDao.deleteStudentOrder(studentOrder);
        }
        if(student != null) {
            studentId = student;
            List<StudentOrder> studentOrders = studentOrderDao.getStudentOrderByStudentId(studentId);
            for(StudentOrder studentOrder : studentOrders) {
                List<Book> books = studentOrder.getBookList();
                for(Book book : books) {
                    bookDao.deleteBook(book.getBookId());
                }
                studentOrderDao.deleteStudentOrder(studentOrder);
            }
        }
        return "redirect:/admin/students/bookApply/"+studentId;
    }

}
