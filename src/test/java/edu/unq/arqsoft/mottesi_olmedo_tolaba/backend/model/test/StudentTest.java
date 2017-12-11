package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;

public class StudentTest {

    @Test
    public void testAccessing(){
        Student student = new Student("Homer", "Simpson", 24888, "homer.simpson@gmail.com", null);
        assertEquals(student.getName(), "Homer");
        assertEquals(student.getLastName(), "Simpson");
        assertEquals(student.getStudentID(), 24888, 0);
        assertEquals(student.getEmail(), "homer.simpson@gmail.com");
    }

}
