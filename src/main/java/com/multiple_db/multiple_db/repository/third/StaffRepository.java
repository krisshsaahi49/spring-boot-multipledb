package com.multiple_db.multiple_db.repository.third;

import com.multiple_db.multiple_db.model.third.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
