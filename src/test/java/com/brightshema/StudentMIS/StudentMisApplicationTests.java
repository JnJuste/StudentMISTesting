package com.brightshema.StudentMIS;

import com.brightshema.StudentMIS.model.Student;
import com.brightshema.StudentMIS.service.StudentService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class StudentMisApplicationTests {

	@Autowired
	private StudentService studentService;

	// Test for Inserting New Student
	@Test
	@Order(1)
	public void testSaveStudent(){
		Student stud = new Student();
		stud.setStudentID(1);
		stud.setStudentNames("Bright SHEMA");
		stud.setStudentEmail("brightshema@gmail.com");
		stud.setStudentPhone("+2500788455332");
		stud.setStudentAddress("KIGALI");

		Student student = studentService.saveStudent(stud);
		assertNotNull(student);
	}

	// Test to find if the number of students are available
	@Test
	@Order(2)
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		assertEquals(1, students.size());
	}

	//Test to find a Email by ID
	@Test
	@Order(3)
	public void testFindById(){
		Student student = studentService.findStudentById(1);
		assertEquals("brightshema@gmail.com", student.getStudentEmail());
	}

	//Test Update Email by ID
	@Test
	@Order(4)
	public void testUpdateEmail() throws Exception {
		Student updateStudent = studentService.updateStudentById(1, "shemab@gmail.com");
		assertEquals("shemab@gmail.com", updateStudent.getStudentEmail());
	}
	//Test Delete Student by ID
	@Test
	@Order(5)
	public void testDeleteById() {
		Boolean isDeleted = studentService.deleteStudentById(1);
		Student student = studentService.findStudentById(1);

		assertNull(student);
		assertEquals(isDeleted, true);
	}
}
