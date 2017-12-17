package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimelineTest {

    @Test
    public void testAccessing(){
        Timeline timeline = new Timeline("Monday", "15:00", "20:00");
        assertEquals(timeline.getDayTime(), "Monday");
        assertEquals(timeline.getStartTime(), "15:00");
        assertEquals(timeline.getEndTime(), "20:00");
    }
}
