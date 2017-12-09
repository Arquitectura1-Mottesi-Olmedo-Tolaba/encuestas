package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;

public class SurveyTest {

	private Subject elem;
	private Option option;
	private SurveyMatch surveyMatch;
	
	@Before
	public void setup() {
		elem = new Subject("Matematica 1");
		option = new Option("Todavia no curso");
		surveyMatch = new SurveyMatch(option, elem);
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
    
    
}
