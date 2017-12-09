package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SubjectDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubjectTest {

    @Test
	public void test_SurveyToDTOConversion() {
		Subject elem = new Subject("Matematica 1");
		elem.setId((long) 123);
		SubjectDTO dto = elem.toSubjectDTO();
		assertEquals(dto.getName(), "Matematica 1");
	}
}
