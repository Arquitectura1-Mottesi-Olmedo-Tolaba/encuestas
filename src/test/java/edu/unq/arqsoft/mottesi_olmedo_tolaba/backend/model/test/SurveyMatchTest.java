package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import org.junit.Test;

public class SurveyMatchTest {

    @Test
    public void testAccessing(){
        Option mockOption = mock(Option.class);
        Subject mockSubject = mock(Subject.class);
        SurveyMatch surveyMatch = new SurveyMatch(mockOption, mockSubject);
        assertEquals(surveyMatch.getOption(), mockOption);
        assertEquals(surveyMatch.getSubject(), mockSubject);
    }

}
