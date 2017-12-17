package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import org.junit.Test;

import java.util.List;

public class StatisticTest {

    @Test
    public void testAccessing(){
        Subject mockSubject = mock(Subject.class);
        List< OptionCounter > mockOptionCounter = mock(List.class);
        Statistic statistic = new Statistic(mockSubject, mockOptionCounter);
        assertEquals(statistic.getSubject(), mockSubject);
        assertEquals(statistic.getOptionsCounter(), mockOptionCounter);
    }
}
