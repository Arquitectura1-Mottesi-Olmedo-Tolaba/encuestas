package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class DegreeServiceTest {
	
    @Autowired
    private DegreeService degreeService;
    
    @Test
    public void testGetDegreeName(){
    	assertEquals(degreeService.getDegreeName(1l), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(degreeService.getDegreeName(2l), "Licenciatura en Biotecnología");
    }
    
    @Test
    public void testGetDegreeNameForAcademicOffer(){
    	assertEquals(degreeService.getDegreeNameForAcademicOffer(1l), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(degreeService.getDegreeNameForAcademicOffer(2l), "Tecnicatura Universitaria en Programacion Informatica");
    	assertEquals(degreeService.getDegreeNameForAcademicOffer(3l), "Licenciatura en Biotecnología");
    	assertEquals(degreeService.getDegreeNameForAcademicOffer(4l), "Licenciatura en Biotecnología");
    }

}
