package com.multiple_db.multiple_db.repository.second;

import com.multiple_db.multiple_db.model.second.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
