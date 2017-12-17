package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;

public class AcademicOfferTest {

    @SuppressWarnings("unchecked")
	@Test
    public void testAccessing(){
        List<Offer> mockOffers = mock(List.class);
        List<Statistic> mockStatistics = mock(List.class);
        Period mockPeriod = mock(Period.class);
        AcademicOffer academicOffer = new AcademicOffer(mockOffers, mockPeriod, "2017-01-03",true, mockStatistics);
        assertEquals(academicOffer.getOffers(), mockOffers);
        assertEquals(academicOffer.getPeriod(), mockPeriod);
        assertEquals(academicOffer.getEndDate(), "2017-01-03");
        assertTrue(academicOffer.isActive());
        assertEquals(academicOffer.getStatistics(), mockStatistics);
    }
    
//    @Test
//    public void testAccessingWithStatistics(){
//    	Subject mockSubject = mock(Subject.class);
//    	Course mockCourse = mock(Course.class);
//    	List<Course> courses = Arrays.asList(mockCourse);
//    	Offer mockOffer = mock(Offer.class);
//    	when(mockOffer.getSubject()).thenReturn(mockSubject);
//    	when(mockOffer.getCourses()).thenReturn(courses);
//        List<Statistic> mockStatistics = mock(List.class);
//        Period mockPeriod = mock(Period.class);
//        
//        AcademicOffer academicOffer = new AcademicOffer(Arrays.asList(mockOffer), mockPeriod, "2017-01-03",true);
//        academicOffer.getStatistics();
//    }

}
