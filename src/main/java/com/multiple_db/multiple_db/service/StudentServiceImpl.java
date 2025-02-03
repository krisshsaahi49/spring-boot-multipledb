package com.multiple_db.multiple_db.service;

import com.multiple_db.multiple_db.model.first.Student;
import com.multiple_db.multiple_db.repository.first.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
