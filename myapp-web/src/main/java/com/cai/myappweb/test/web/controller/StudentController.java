package com.cai.myappweb.test.web.controller;

import com.cai.myappweb.test.domain.Student;
import com.cai.myappweb.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cjt
 * @date 2020/2/25 16:23
 */
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students/{id}")
    public Student get(@PathVariable("id")Long id) {
        return studentService.get(id);
    }
    @PostMapping("/students")
    public Integer addUser(Student s) {
        return studentService.insert(s);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
