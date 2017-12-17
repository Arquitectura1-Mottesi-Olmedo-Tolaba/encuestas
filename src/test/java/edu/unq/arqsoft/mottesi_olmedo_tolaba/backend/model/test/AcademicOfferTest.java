package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.*;

import java.util.List;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AcademicOfferTest {

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

}
