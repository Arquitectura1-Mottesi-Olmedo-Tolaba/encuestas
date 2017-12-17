package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeriodTest {

    @Test
    public void testAccessing(){
        Period period = new Period(2017, 1);
        assertEquals(period.getYear(), 2017, 0);
        assertEquals(period.getQuarter(), 1, 0);
    }
}
