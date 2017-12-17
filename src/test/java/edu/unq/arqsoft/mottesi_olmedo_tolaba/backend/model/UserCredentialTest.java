package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import static org.junit.Assert.assertEquals;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import org.junit.Test;

public class UserCredentialTest {

    @Test
    public void testAccessing(){
         UserCredential userCredential = new UserCredential("email@email.com", "password");
        assertEquals(userCredential.getEmail(), "email@email.com");
        assertEquals(userCredential.getPassword(), "password");
    }
}
