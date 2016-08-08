package com.elibmanager.controller;

import com.elibmanager.dao.ApplyDao;
import com.elibmanager.dao.ApplyItemDao;
import com.elibmanager.dao.BookDao;
import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Apply;
import com.elibmanager.model.ApplyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    
    @RequestMapping("/{applyId}")
    public @ResponseBody
    Apply getApplyById(@PathVariable(value = "applyId") int applyId) {
        return applyDao.getApplyById(applyId);
    }

    @RequestMapping(value = "/remove/{applyId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "bookId") int bookId) {
        ApplyItem applyItem = applyItemDao.getApplyItemByBookId(bookId);
        applyItemDao.removeApplyItem(applyItem);
    }

    @RequestMapping(value = "/{applyId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void  clearApply(@PathVariable(value = "applyId") int applyId) {
        Apply apply = applyDao.getApplyById(applyId);
        applyItemDao.removeAllApplyItems(apply);
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