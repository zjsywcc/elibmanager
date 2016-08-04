package com.elibmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wcc on 2016/8/4.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        return "index";
    }

    @RequestMapping("/booklist")
    public String BookList() {
        return "booklist";
    }
}
