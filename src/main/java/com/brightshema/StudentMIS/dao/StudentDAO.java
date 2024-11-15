package com.brightshema.StudentMIS.dao;

import com.brightshema.StudentMIS.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Integer> {
    List<Student> findByStudentEmail(String studentEmail);
}
