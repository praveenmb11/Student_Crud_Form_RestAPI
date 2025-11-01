package com.std.student_man.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.std.student_man.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
