package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void testAccessing(){
        Professor professor = new Professor("Homer");
        assertEquals(professor.getName(), "Homer");
    }
}
