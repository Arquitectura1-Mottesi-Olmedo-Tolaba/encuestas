package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.fakeData;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import org.junit.Test;
import static org.junit.Assert.*;

public class FakeDataTest {

    @Test
    public void testDegreeTPI(){
        Degree degree = new FakeData().degreeTPI();
        assertEquals(degree.getName(), "Tecnicatura Universitaria en Programacion Informatica");
        assertEquals(degree.getSubjects().size(), 31);
        assertEquals(degree.getAcademicOffers().size(), 2);

        AcademicOffer academicOffer1 = degree.getAcademicOffers().get(0);
        assertEquals(academicOffer1.getPeriod().getYear(), 2017, 0);
        assertEquals(academicOffer1.getPeriod().getQuarter(), 1, 0);
        assertEquals(academicOffer1.getOffers().size(), 31);
        assertEquals(academicOffer1.getEndDate(), "2017-03-01");
        assertFalse(academicOffer1.isActive());

        AcademicOffer academicOffer2 = degree.getAcademicOffers().get(1);
        assertEquals(academicOffer2.getPeriod().getYear(), 2017, 0);
        assertEquals(academicOffer2.getPeriod().getQuarter(), 2, 0);
        assertEquals(academicOffer2.getOffers().size(), 31);
        assertEquals(academicOffer2.getEndDate(), "2017-08-01");
        assertTrue(academicOffer2.isActive());
    }

    @Test
    public void testDegreeLICBIO(){
        Degree degree = new FakeData().degreeLICBIO();
        assertEquals(degree.getName(), "Licenciatura en Biotecnología");
        assertEquals(degree.getSubjects().size(), 31);
        assertEquals(degree.getAcademicOffers().size(), 2);

        AcademicOffer academicOffer1 = degree.getAcademicOffers().get(0);
        assertEquals(academicOffer1.getPeriod().getYear(), 2017, 0);
        assertEquals(academicOffer1.getPeriod().getQuarter(), 1, 0);
        assertEquals(academicOffer1.getOffers().size(), 31);
        assertFalse(academicOffer1.isActive());
        assertEquals(academicOffer1.getEndDate(), "2017-03-01");

        AcademicOffer academicOffer2 = degree.getAcademicOffers().get(1);
        assertEquals(academicOffer2.getPeriod().getYear(), 2017, 0);
        assertEquals(academicOffer2.getPeriod().getQuarter(), 2, 0);
        assertEquals(academicOffer2.getOffers().size(), 31);
        assertEquals(academicOffer2.getEndDate(), "2017-08-01");
        assertTrue(academicOffer2.isActive());
    }

}
