package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.test;

import static org.junit.Assert.assertEquals;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.TimeResponse;
import org.junit.Test;

import java.util.Date;

public class TimeResponseTest {

    @Test
    public void testAccessing(){
        Date reservationTime = new Date();
        Date responseTime = new Date();
        TimeResponse timeResponse = new TimeResponse(reservationTime, responseTime);
        assertEquals(timeResponse.getReservationTime(), reservationTime);
        assertEquals(timeResponse.getResponseTime(), responseTime);
    }

}
