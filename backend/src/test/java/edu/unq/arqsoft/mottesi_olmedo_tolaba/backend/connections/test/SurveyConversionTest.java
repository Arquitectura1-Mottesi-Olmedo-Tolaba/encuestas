package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.connections.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.OptionService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.SubjectService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.SurveyMatchService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.SurveyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class SurveyConversionTest {

	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private SurveyMatchService surveyMatchService;
	
	@Autowired
	private OptionService optionService;
	
	@Autowired
	private SubjectService subjectService;
	
	private Subject elem;
	private Option option;
	private SurveyMatch surveyMatch;	
	
	
	@Before
	public void setup() {
		
		elem = new Subject("Matematica 1");
		subjectService.save(elem);

		option = new Option("Todavia no curso");
		optionService.save(option);
		
		surveyMatch = new SurveyMatch(option, elem);
		surveyMatchService.save(surveyMatch);
		
		
	}
    
    @Test
	public void test_SurveyMatchDTOConversion() {
		SurveyMatchDTO dto = surveyMatch.toSurveyMatchDTO();		
		assertEquals(dto.subject.getName(), "Matematica 1");
		assertEquals(dto.option.getDescription(), "Todavia no curso");
	}
    
    @Test
   	public void test_SurveyDTOCreation() {
    	SurveyDTO dto = new SurveyDTO();
    	dto.addSurveyMatchDTO(surveyMatch.toSurveyMatchDTO());   		
   		assertEquals(dto.surveyMatches.get(0).subject.getName(), "Matematica 1");
   		assertEquals(dto.surveyMatches.get(0).option.getDescription(), "Todavia no curso");
   	}
    
    @Test
   	public void test_SurveytoDTOConversion() {
    	Survey survey = new Survey();
    	survey.addSurveyMatch(surveyMatch); 
    	SurveyDTO dto = survey.toSurveyDTO();
   		assertEquals(dto.surveyMatches.get(0).subject.getName(), "Matematica 1");
   		assertEquals(dto.surveyMatches.get(0).option.getDescription(), "Todavia no curso");
   	}
	
	/*
	@Test
	public void test_PersistANewStudent() {
		Student elem = service.findByStudentId(studentId);
		assertEquals(elem.getName(), "Homer");
		assertEquals(elem.getLastName(), "Simpson");
		assertEquals(elem.getStudentID(), studentId);
		assertEquals(elem.getEmail(), "homer.simpson@gmail.com");
	}
	
	@Test
	public void test_FindANewStudent() {
		Student elem = service.findByStudentId(studentId);
		assertEquals(elem.getName(), "Homer");
		assertEquals(elem.getLastName(), "Simpson");
		assertEquals(elem.getStudentID(), studentId);
		assertEquals(elem.getEmail(), "homer.simpson@gmail.com");
	}
	*/
	
}
