package com.elibmanager.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wcc on 2016/8/10.
 */
@Controller
@RequestMapping("/admin/students")
public class AdminStudent {

    @RequestMapping("/authority/{studentId}")
    public String authorityManagement(@PathVariable("studentId") int studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "authorityManagement";
    }

    @RequestMapping("/bookApply/{studentId}")
    public String applyChecking(@PathVariable("studentId") int studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "applyChecking";
    }

}
