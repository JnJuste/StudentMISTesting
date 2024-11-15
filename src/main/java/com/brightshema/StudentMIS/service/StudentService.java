package com.brightshema.StudentMIS.service;

import com.brightshema.StudentMIS.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> findAllStudents();
    Student findStudentById(Integer studID);
    boolean deleteStudentById(Integer studID);
    Student updateStudentById
            (Integer studID, String email)
            throws Exception;
    List<Student> findByStudentEmail(String email);
}
