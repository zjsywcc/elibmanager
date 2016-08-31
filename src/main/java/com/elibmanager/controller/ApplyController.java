package com.elibmanager.controller;

import com.elibmanager.dao.*;
import com.elibmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mengchenyun on 2016/8/8.
 */

@Controller
@RequestMapping("/rest/apply")
public class ApplyController {

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookInfoDao bookInfoDao;
    
    @RequestMapping(value= "/{applyId}", method = RequestMethod.GET)
    public @ResponseBody
    Apply getApplyById(@PathVariable(value = "applyId") int applyId) {
        Apply apply = applyDao.getApplyById(applyId);
        return apply;
    }

    @RequestMapping(value = "/remove/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "bookId") int bookId) {
        ApplyItem applyItem = applyItemDao.getApplyItemByBookId(bookId);
        applyItemDao.removeApplyItem(applyItem);
        bookDao.deleteBook(bookId);

        Apply apply = applyItem.getApply();
        double grandTotal = apply.getGrandTotal();
        grandTotal -= applyItem.getTotalPrice();
        apply.setGrandTotal(grandTotal);
        applyDao.editApply(apply);
    }

    @RequestMapping(value = "/{applyId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void  clearApply(@PathVariable(value = "applyId") int applyId) {
        Apply apply = applyDao.getApplyById(applyId);
        apply.setGrandTotal(0);
        applyItemDao.removeAllApplyItems(apply);
        List<ApplyItem> applyItems = apply.getApplyItems();
        for(ApplyItem applyItem : applyItems) {
            bookDao.deleteBook(applyItem.getBook().getBookId());
        }
        applyDao.editApply(apply);
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addToApply(@AuthenticationPrincipal User activeUser, @PathVariable("id") Integer id) {
        String username = activeUser.getUsername();
        String studentName = studentDao.getStudentByUsername(username).getStudentName();
        Student student = studentDao.getStudentByUsername(activeUser.getUsername());
        Apply apply = student.getApply();
        double totalPrice = apply.getGrandTotal();
        List<ApplyItem> applyItems = apply.getApplyItems();

        BookInfo bookInfo = bookInfoDao.getBookInfoById(id);
        Book book = new Book();
        book.setBookStatus("checking");
        book.setBookOwner(studentName);

        book.setBookName(bookInfo.getBookName());
        book.setBookAuthor(bookInfo.getBookAuthor());
        book.setBookEdition(bookInfo.getBookEdition());
        //TODO need to solve the type of price...
        book.setBookPrice(1.0);
        book.setBookPress(bookInfo.getBookPress());
        book.setBookISBN(bookInfo.getBookISBN());


        book.setStudent(student);
        bookDao.addBook(book);

        ApplyItem applyItem = new ApplyItem();
        applyItem.setBook(book);
        applyItem.setQuantity(1);
        applyItem.setTotalPrice(book.getBookPrice());
        applyItem.setApply(apply);
        applyItemDao.addApplyItem(applyItem);
        totalPrice += book.getBookPrice();

        apply.setGrandTotal(totalPrice);
        applyDao.editApply(apply);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors(Exception e) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors(Exception e) {
    }
}
