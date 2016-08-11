package com.elibmanager.controller.admin;

import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wcc on 2016/8/11.
 */
@Controller
@RequestMapping("/rest/studentManagement")
public class StudentManagement {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/{studentId}")
    public @ResponseBody
    Student getStudentById(@PathVariable("studentId") int studentId) {
        Student student = studentDao.getStudentById(studentId);
        return student;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editStudentInfo(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        initMap(model);
        if (result.hasErrors()) {
            return "studentManagement";
        }
        studentDao.editStudent(student);
        return "redirect:/admin/students";
    }

    @RequestMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        studentDao.deleteStudent(studentId);
        return "redirect:/admin/students";
    }

    // just pass map to radiobuttons in ftl
    public void initMap(Model model) {
        Map status = new LinkedHashMap();
        status.put("true", "true");
        status.put("false", "false");
        model.addAttribute("status", status);
    }
}
