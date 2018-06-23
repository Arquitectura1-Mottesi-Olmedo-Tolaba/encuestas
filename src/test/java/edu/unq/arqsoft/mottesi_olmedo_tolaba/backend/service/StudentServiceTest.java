package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentOfferDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.StudentSurvey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class StudentServiceTest {
    
    @Autowired
	private SurveyService surveyService;
    
    @Test
    public void testVerifyCode(){
    	String code = surveyService.findCodes(1l).get(0);
    	assertTrue(surveyService.verifyCode(code));
    	assertFalse(surveyService.verifyCode("CODE"));
    }
    
    @Test
    public void testGetSurveyByCode(){
    	String code = surveyService.findCodes(1l).get(0);
    	StudentSurveyDTO studentSurveyDTO = surveyService.getSurveyByCode(code);
    	assertEquals(studentSurveyDTO.getName(), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(studentSurveyDTO.getOffers().size(), 31, 0);
    	assertEquals(studentSurveyDTO.getMessage(), "");
    	assertEquals(studentSurveyDTO.getPeriod().getYear(), 2017, 0);
    	assertEquals(studentSurveyDTO.getPeriod().getQuarter(), 2, 0);
    }
    
    @Test
    public void testCompleteSurvey(){
    	String code = surveyService.findCodes(2l).get(1);
    	
    	StudentSurveyDTO studentSurveyDTO = surveyService.getSurveyByCode(code);
    	assertEquals(studentSurveyDTO.getName(), "Licenciatura en Biotecnologia");
    	assertEquals(studentSurveyDTO.getOffers().size(), 31, 0);
    	assertEquals(studentSurveyDTO.getMessage(), "");
    	assertEquals(studentSurveyDTO.getPeriod().getYear(), 2017, 0);
    	assertEquals(studentSurveyDTO.getPeriod().getQuarter(), 2, 0);
    	
    	StudentSurvey studentSurvey = new StudentSurvey(code, this.generateSurveyMatches(studentSurveyDTO.getOffers()), "hello");
    	
    	surveyService.completeSurvey(studentSurvey);
    	
    	studentSurveyDTO = surveyService.getSurveyByCode(code);
    	assertEquals(studentSurveyDTO.getName(), "Licenciatura en Biotecnologia");
    	assertEquals(studentSurveyDTO.getOffers().size(), 31, 0);
    	assertEquals(studentSurveyDTO.getMessage(), "hello");
    	assertEquals(studentSurveyDTO.getPeriod().getYear(), 2017, 0);
    	assertEquals(studentSurveyDTO.getPeriod().getQuarter(), 2, 0);
    }

	private List<SurveyMatch> generateSurveyMatches(List<StudentOfferDTO> offers) {
		return offers.stream().map(offer -> new SurveyMatch(offer.getSelectedOption(), offer.getSubject())).collect(Collectors.toList());		
	}

}
