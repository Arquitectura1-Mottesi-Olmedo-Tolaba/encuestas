package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import org.junit.Test;

public class OptionTest {

    @Test
    public void testAccessing() {
        Option option = new Option("Description");
        assertEquals(option.getDescription(), "Description");
    }
}
