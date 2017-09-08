package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.UserService;

@Service
public class BeansInjectorService {
	
	
	@Autowired
	private UserService userService;
	
	
    /**
     * En este método se deben inicializar todas las entidades básicas y
     * necesarias para comenzar.
     */
		
	
    @PostConstruct
    @Transactional
    public void initialize() {
    	UserCredential user = userService.createUser("fake", "fake123", "fake@gmail.com");
    	
    }
    
}
