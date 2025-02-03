package com.multiple_db.multiple_db.service;

import com.multiple_db.multiple_db.model.third.Staff;
import com.multiple_db.multiple_db.repository.third.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }
}
