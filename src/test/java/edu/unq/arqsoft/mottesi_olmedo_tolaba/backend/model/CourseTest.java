package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class CourseTest {

    @Test
    public void testAccessing(){
        Professor mockProfessor = mock(Professor.class);
        List<Timeline> mockTimelines = mock(List.class);
        Course course = new Course("Comision 1", mockProfessor, mockTimelines, 30);
        assertEquals(course.getProfessor(), mockProfessor);
        assertEquals(course.getTimelines(), mockTimelines);
        assertEquals(course.getQuantity(), 30, 0);
    }

}
