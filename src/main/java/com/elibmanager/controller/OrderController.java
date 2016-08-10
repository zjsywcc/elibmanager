package com.elibmanager.controller;

import com.elibmanager.dao.*;
import com.elibmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcc on 2016/8/10.
 */

@Controller
@RequestMapping("/rest/apply")
public class OrderController {

    @Autowired
    private StudentOrderDao studentOrderDao;

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/order/{applyId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createOrder(@PathVariable("applyId") int applyId) {
        StudentOrder studentOrder = new StudentOrder();

        Apply apply = applyDao.getApplyById(applyId);
        studentOrder.setApply(apply);

        studentOrder.setStudent(apply.getStudent());
        List<ApplyItem> applyItems = apply.getApplyItems();
        List<Book> books = new ArrayList<Book>();
        for(ApplyItem applyItem : applyItems) {
            Book book = applyItem.getBook();
            book.setStudentOrder(studentOrder);
            books.add(book);
        }
        studentOrder.setBookList(books);
        studentOrderDao.addStudentOrder(studentOrder);
        applyItemDao.removeAllApplyItems(apply);
    }
}
