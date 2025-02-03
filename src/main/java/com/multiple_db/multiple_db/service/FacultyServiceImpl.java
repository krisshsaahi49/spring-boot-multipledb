package com.multiple_db.multiple_db.service;

import com.multiple_db.multiple_db.model.second.Faculty;
import com.multiple_db.multiple_db.repository.second.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
