package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import org.junit.Test;

import java.util.List;

public class DirectorTest {

    @Test
    public void testAccessing() {
        List<Degree> mockDegrees = mock(List.class);
        UserCredential mockUserCredential = mock(UserCredential.class);
        Director director = new Director(mockDegrees, mockUserCredential);
        assertEquals(director.getDegrees(), mockDegrees);
        assertEquals(director.getCredential(), mockUserCredential);
    }

}
