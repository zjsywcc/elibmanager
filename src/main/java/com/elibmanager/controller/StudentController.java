package com.elibmanager.controller;

import com.elibmanager.dao.ApplyDao;
import com.elibmanager.dao.ApplyItemDao;
import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private ApplyDao applyDao;

    @RequestMapping("/myBooks")
    public String getMyBooks(@AuthenticationPrincipal User activeUser, Model model) {
        Student student = studentDao.getStudentByUsername(activeUser.getUsername());
        List<Book> bookList = student.getBookList();
        model.addAttribute("books", bookList);
        return "myBooks";
    }

    @RequestMapping("/applyForBooks")
    public String applyForBooks(Model model) {
        BookListWrapper bookListWrapper = new BookListWrapper();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setBookStatus("checking");
        book2.setBookStatus("checking");
        book3.setBookStatus("checking");
        bookListWrapper.add(book1);
        bookListWrapper.add(book2);
        bookListWrapper.add(book3);
        model.addAttribute("bookListWrapper", bookListWrapper);
        return "applyForBooks";
    }

    @RequestMapping(value = "/applyForBooks", method = RequestMethod.POST)
    public String applyForBooksPost(@Valid @ModelAttribute("bookListWrapper") BookListWrapper bookListWrapper, BindingResult result, @AuthenticationPrincipal User activeUser, Model model) {
        List<Book> books = bookListWrapper.getBookList();
        Student student = studentDao.getStudentByUsername(activeUser.getUsername());
        for(Book book : books) {
            book.setStudent(student);
        }
        bookDao.addAllBooks(books);
        Apply apply = student.getApply();
        List<ApplyItem> applyItems = apply.getApplyItems();
        for(Book book : books) {
            if(applyItems.size() < 3) {
                ApplyItem applyItem = new ApplyItem();
                applyItem.setBook(book);
                applyItem.setQuantity(1);
                applyItem.setTotalPrice(book.getBookPrice());
                applyItem.setApply(apply);
                applyItemDao.addApplyItem(applyItem);
            } else {
                model.addAttribute("maxApplyNumError","You can only apply for 3 books!");
                return "/applyForBooks";
            }
        }
        return "redirect:/student/applyList";
    }

    @RequestMapping("/applyList")
    public String getApply(@AuthenticationPrincipal User activeUser) {
        Student student = studentDao.getStudentByUsername(activeUser.getUsername());
        int applyId = student.getApply().getApplyId();

        return "redirect:/student/applyList/"+applyId;
    }

    @RequestMapping("/applyList/{applyId}")
    public String getApplyRedirect(@PathVariable(value = "applyId") int applyId, Model model) {
        model.addAttribute("applyId", applyId);
        return "applyList";
    }

}
