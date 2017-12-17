package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import static org.junit.Assert.assertEquals;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import org.junit.Test;

public class OptionCounterTest {

    @Test
    public void testAccessing(){
        OptionCounter optionCounter = new OptionCounter("Description", 50, 10);
        assertEquals(optionCounter.getDescription(), "Description");
        assertEquals(optionCounter.getCapacity(), 50, 0);
        assertEquals(optionCounter.getAmount(), 10, 0);
    }
}
