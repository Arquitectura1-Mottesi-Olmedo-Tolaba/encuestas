package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class DegreeTest {

    @Test
    public void testAccessing(){
        List<Subject> subjects = mock(List.class);
        List<AcademicOffer> academicOffers = mock(List.class);
        Degree degree = new Degree("TPI", subjects, academicOffers);
        assertEquals(degree.getName(), "TPI");
        assertEquals(degree.getSubjects(), subjects);
        assertEquals(degree.getAcademicOffers(), academicOffers);
    }

}
