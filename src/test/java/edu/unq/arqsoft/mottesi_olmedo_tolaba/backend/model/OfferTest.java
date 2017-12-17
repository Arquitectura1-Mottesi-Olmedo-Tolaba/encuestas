package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class OfferTest {

    @Test
    public void testAccessing() {
        Subject mockSubject = mock(Subject.class);
        List<Course> mockCourses = mock(List.class);
        Offer offer = new Offer(mockSubject, mockCourses);
        assertEquals(offer.getCourses(), mockCourses);
        assertEquals(offer.getSubject(), mockSubject);
    }

}
