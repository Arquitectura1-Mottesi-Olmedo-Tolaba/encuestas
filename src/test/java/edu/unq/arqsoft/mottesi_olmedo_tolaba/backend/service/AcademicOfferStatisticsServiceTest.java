package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.AcademicOfferStatisticsDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class AcademicOfferStatisticsServiceTest {
	
    @Autowired
    private AcademicOfferStatisticsService academicOfferStatisticsService;
	
	@Test
	public void testGetAcademicOfferInformation(){
		AcademicOfferStatisticsDTO academicOfferStatisticsDTO = academicOfferStatisticsService.getAcademicOfferInformation(1l);
		assertEquals(academicOfferStatisticsDTO.getDay(), "2017-08-01");
		assertEquals(academicOfferStatisticsDTO.getName(), "Tecnicatura Universitaria en Programacion Informatica");
		assertEquals(academicOfferStatisticsDTO.getStudentInformationDTO().getCompleted(), 0, 0);
		assertEquals(academicOfferStatisticsDTO.getStudentInformationDTO().getTotal(), 100, 0);
		assertEquals(academicOfferStatisticsDTO.getOffers().size(), 31);
		academicOfferStatisticsDTO.getOffers()
			.forEach(offer -> offer.getInfo()
				.forEach(info -> {
					assertEquals(info.getAmount(), 0, 0);
					if(info.getName().contains("Comision")) assertEquals(info.getCapacity(), 25, 0);
				})
			);
	}

}
