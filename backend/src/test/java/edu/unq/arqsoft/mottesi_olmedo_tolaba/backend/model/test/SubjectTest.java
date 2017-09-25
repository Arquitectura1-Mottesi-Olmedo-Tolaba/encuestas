package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubjectTest {

    @Test
    public void testAccessing(){
        Subject subject = new Subject("Arquitectura");
        assertEquals(subject.getName(), "Arquitectura");
    }
}
