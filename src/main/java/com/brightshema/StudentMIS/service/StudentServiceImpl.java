package com.brightshema.StudentMIS.service;

import com.brightshema.StudentMIS.dao.StudentDAO;
import com.brightshema.StudentMIS.model.Student;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDAO studentDAO;
    @Override
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student findStudentById(Integer studID) {
        Student student = studentDAO.findById(studID).orElse(null);
        if (student == null) {
            return null;
        } else {
            return student;
        }
    }

    @Override
    public boolean deleteStudentById(Integer studID) {
        Student student = studentDAO.findById(studID).orElse(null);
        if (student != null) {
            studentDAO.delete(student);
            return true;
        }
        return false;
    }

    @Override
    public Student updateStudentById(Integer studID, String email) throws Exception {
        Student student = studentDAO.findById(studID).orElse(null);
        if (student != null) {
            student.setStudentEmail(email);
            return studentDAO.save(student);
        } else {
            throw new ObjectNotFoundException(Student.class, String.valueOf(studID));
        }
    }

    @Override
    public List<Student> findByStudentEmail(String studentEmail) {
        return studentDAO.findByStudentEmail(studentEmail);
    }
}
