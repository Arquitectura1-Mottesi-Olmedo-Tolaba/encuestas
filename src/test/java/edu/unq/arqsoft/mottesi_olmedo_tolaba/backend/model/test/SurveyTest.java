package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Student;
import org.junit.Test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;

import java.util.ArrayList;
import java.util.List;

public class SurveyTest {

    @Test
	public void testAccessing() {
        List<SurveyMatch> surveyMatches = new ArrayList<>();
        Student mockStudent = mock(Student.class);
        AcademicOffer mockAcademicOffer = mock(AcademicOffer.class);
		Survey survey = new Survey(surveyMatches, "CODE", false, "message", mockStudent, mockAcademicOffer);
        assertEquals(survey.getSurveyMatches(), surveyMatches);
        assertEquals(survey.getCode(), "CODE");
        assertFalse(survey.getWasAnswered());
        assertEquals(survey.getMessage(), "message");
        assertEquals(survey.getStudent(), mockStudent);
        assertEquals(survey.getAcademicOffer(), mockAcademicOffer);
	}

}
