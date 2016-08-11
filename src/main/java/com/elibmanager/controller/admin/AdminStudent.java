package com.elibmanager.controller.admin;

import com.elibmanager.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wcc on 2016/8/10.
 */
@Controller
@RequestMapping("/admin/students")
public class AdminStudent {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/studentManagement/{studentId}")
    public String authorityManagement(@PathVariable("studentId") int studentId, Model model) {
        initMap(model);
        model.addAttribute("studentId", studentId);
        model.addAttribute("student", studentDao.getStudentById(studentId));
        return "studentManagement";
    }

    @RequestMapping("/bookApply/{studentId}")
    public String applyChecking(@PathVariable("studentId") int studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "applyChecking";
    }

    // just pass map to radiobuttons in ftl
    public void initMap(Model model) {
        Map status = new LinkedHashMap();
        status.put("true", "true");
        status.put("false", "false");
        model.addAttribute("status", status);
    }

}
