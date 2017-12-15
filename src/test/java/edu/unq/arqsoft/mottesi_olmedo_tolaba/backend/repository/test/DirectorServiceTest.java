package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.test;

import static org.junit.Assert.*;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.DirectorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class DirectorServiceTest {

    @Autowired
    private DirectorService service;

    @Test
    public void testLogin(){
        service.save(new Director(new ArrayList<Degree>(),new UserCredential("example@example.com", "password")));
        Director director = service.findDirector(new UserCredential("example@example.com", "password"));
        assertEquals(director.getCredential().getEmail(), "example@example.com");
        assertEquals(director.getCredential().getPassword(), "password");
        assertEquals(director.getDegrees().size(), 0);
    }

}
