package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StudentSurveyDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class SurveyServiceTest {
	
    @Autowired
    private SurveyService service;
    
    @Test
    public void testFindCodes(){
    	assertEquals(service.findAll().size(), 199, 0);
    }
    
    @Test
    public void testVerifyCode(){
    	String code = service.findCodes().get(0);
    	assertTrue(service.verifyCode(code));
    	assertFalse(service.verifyCode("CODE"));
    }
    
    @Test
    public void testSurveysCompletedOf(){
    	assertEquals(service.surveysCompletedOf(2l), 0, 0);
    }
    
    @Test
    public void testGetSurveyByCode(){
    	String code = service.findCodes().get(3);
    	StudentSurveyDTO studentSurveyDTO = service.getSurveyByCode(code);
    	assertEquals(studentSurveyDTO.getName(), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(studentSurveyDTO.getOffers().size(), 31, 0);
    	assertEquals(studentSurveyDTO.getMessage(), "");
    	assertEquals(studentSurveyDTO.getPeriod().getYear(), 2017, 0);
    	assertEquals(studentSurveyDTO.getPeriod().getQuarter(), 2, 0);
    }

}
