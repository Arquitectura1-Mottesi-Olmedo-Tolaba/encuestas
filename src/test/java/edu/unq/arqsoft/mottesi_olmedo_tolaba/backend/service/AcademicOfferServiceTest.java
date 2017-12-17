package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class AcademicOfferServiceTest {
	
    @Autowired
    private AcademicOfferService academicOfferService;
	
	@Test
	public void testGetCurrentAcademicOfferFor(){
		AcademicOffer academicOffer = academicOfferService.getCurrentAcademicOfferFor(2l);
		assertTrue(academicOffer.isActive());
        assertEquals(academicOffer.getPeriod().getYear(), 2017, 0);
        assertEquals(academicOffer.getPeriod().getQuarter(), 2, 0);
        assertEquals(academicOffer.getOffers().size(), 31);
        assertEquals(academicOffer.getEndDate(), "2017-08-01");
        assertEquals(academicOffer.getStatistics().size(), 31);
        assertEquals(academicOffer.getStatistics().size(), 31);
        academicOffer.getStatistics()
        	.forEach(stadistic -> stadistic.getOptionsCounter()
        			.forEach(optionCounter -> assertEquals(optionCounter.getAmount(), 0, 0)));
	}

}
