package com.multiple_db.multiple_db.controller;


import com.multiple_db.multiple_db.model.second.Faculty;
import com.multiple_db.multiple_db.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    @PostMapping
    public ResponseEntity<Faculty> saveStudent(@RequestBody Faculty faculty){
        return ResponseEntity.status(201).body(facultyService.addFaculty(faculty));
    }
}
