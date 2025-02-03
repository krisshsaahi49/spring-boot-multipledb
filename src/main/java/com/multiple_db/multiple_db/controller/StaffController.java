package com.multiple_db.multiple_db.controller;

import com.multiple_db.multiple_db.model.third.Staff;
import com.multiple_db.multiple_db.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff){
        return ResponseEntity.status(201).body(staffService.addStaff(staff));
    }
}
