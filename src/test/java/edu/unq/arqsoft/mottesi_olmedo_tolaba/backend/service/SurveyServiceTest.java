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
    	assertEquals(service.findCodes(1l).size(), 100, 0);
    	assertEquals(service.findCodes(2l).size(), 99, 0);
    	assertEquals(service.findCodes(3l).size(), 99, 0);
    }
    
    @Test
    public void testVerifyCode(){
    	String code = service.findCodes(1l).get(0);
    	assertTrue(service.verifyCode(code));
    	assertFalse(service.verifyCode("CODE"));
    }
    
    @Test
    public void testSurveysCompletedOf(){
    	assertEquals(service.surveysCompletedOf(2l), 0, 0);
    }
    
    @Test
    public void testGetSurveyByCode(){
    	String code = service.findCodes(1l).get(3);
    	StudentSurveyDTO studentSurveyDTO = service.getSurveyByCode(code);
    	assertEquals(studentSurveyDTO.getName(), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(studentSurveyDTO.getOffers().size(), 31, 0);
    	assertEquals(studentSurveyDTO.getMessage(), "");
    	assertEquals(studentSurveyDTO.getPeriod().getYear(), 2017, 0);
    	assertEquals(studentSurveyDTO.getPeriod().getQuarter(), 2, 0);
    }

}
