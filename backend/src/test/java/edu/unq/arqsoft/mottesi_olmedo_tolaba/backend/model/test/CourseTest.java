package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class CourseTest {

    @Test
    public void testAccessing(){
        Professor professor = mock(Professor.class);
        Subject subject = mock(Subject.class);
        List<Timeline> timelines = mock(List.class);
    }
}
