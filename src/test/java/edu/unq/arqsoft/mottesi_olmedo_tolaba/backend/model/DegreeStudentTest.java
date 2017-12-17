package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.DegreeStudent;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import org.junit.Test;

public class DegreeStudentTest {

    @Test
    public void testAccessing(){
        Student mockStudent = mock(Student.class);
        Degree mockDegree = mock(Degree.class);
        DegreeStudent degreeStudent = new DegreeStudent(mockStudent, mockDegree);
        assertEquals(degreeStudent.getStudent(), mockStudent);
        assertEquals(degreeStudent.getDegree(), mockDegree);
    }

}
