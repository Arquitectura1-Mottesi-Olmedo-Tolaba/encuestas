package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class DegreeStudentServiceTest {
	
    @Autowired
    private DegreeStudentService degreeStudentService;
	
	@Test
	public void testStudentsForDegree(){
		assertEquals(degreeStudentService.studentsForDegree(1l), 100, 0);
		assertEquals(degreeStudentService.studentsForDegree(2l), 99, 0);
	}

}
