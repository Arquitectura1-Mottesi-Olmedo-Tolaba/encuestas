package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class StudentPersistenceTest {

	@Autowired
	private StudentService service;
	
	private Student student;

	private Integer studentId;
	
	@Before
	public void setup() {
		studentId = 24888;
		student = new Student();
		student.setId((long)studentId);
		student.setName("Homer");
		student.setLastName("Simpson");
		student.setEmail("homer.simpson@gmail.com");
		service.save(student);
	}
	
	@Test
	public void test_PersistANewStudent() {
		Student elem = service.findByStudentId(studentId);
		assertEquals(elem.getName(), "Homer");
		assertEquals(elem.getLastName(), "Simpson");
		assertEquals(elem.getStudentID(), studentId);
		assertEquals(elem.getEmail(), "homer.simpson@gmail.com");
	}
	
	@Test
	public void test_FindANewStudent() {
		Student elem = service.findByStudentId(studentId);
		assertEquals(elem.getName(), "Homer");
		assertEquals(elem.getLastName(), "Simpson");
		assertEquals(elem.getStudentID(), studentId);
		assertEquals(elem.getEmail(), "homer.simpson@gmail.com");
	}
	
}
