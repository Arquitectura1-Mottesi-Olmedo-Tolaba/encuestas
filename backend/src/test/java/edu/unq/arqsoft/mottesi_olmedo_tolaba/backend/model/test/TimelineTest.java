package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import org.joda.time.LocalTime;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimelineTest {

    @Test
    public void testAccessing(){
        LocalTime starts = LocalTime.parse("15:00:00");
        LocalTime ends = LocalTime.parse("20:00:00");
        Timeline timeline = new Timeline("Monday", starts, ends);
        assertEquals(timeline.getDay(), "Monday");
        assertEquals(timeline.getStart(), starts);
        assertEquals(timeline.getEnd(), ends);
    }
}
