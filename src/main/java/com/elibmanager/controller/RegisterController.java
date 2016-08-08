package com.elibmanager.controller;

import com.elibmanager.dao.StudentDao;
import com.elibmanager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wcc on 2016/8/8.
 */

@Controller
public class RegisterController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/register")
    public String registerStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "registerStudent";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerStudentPost(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "registerStudent";
        }

        List<Student> studentList = studentDao.getAllStudents();

        for(int i = 0; i < studentList.size(); i++) {
            if(student.getStudentEmail().equals(studentList.get(i).getStudentEmail())) {
                model.addAttribute("emailError", "Email already exists!");
                return "registerStudent";
            }
            if(student.getUsername().equals(studentList.get(i).getUsername())) {
                model.addAttribute("usernameError", "Username already exists!");
                return "registerStudent";
            }
        }
        student.setEnabled(true);
        studentDao.addStudent(student);
        return "registerStudentSuccess";
    }
}
