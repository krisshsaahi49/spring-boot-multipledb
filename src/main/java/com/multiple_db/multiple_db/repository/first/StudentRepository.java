package com.multiple_db.multiple_db.repository.first;

import com.multiple_db.multiple_db.model.first.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
