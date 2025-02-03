package com.multiple_db.multiple_db.controller;

import com.multiple_db.multiple_db.model.first.Student;
import com.multiple_db.multiple_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.status(201).body(studentService.addStudent(student));
    }
}
