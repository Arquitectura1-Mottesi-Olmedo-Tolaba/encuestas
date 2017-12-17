package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesInitializationService {

	@Autowired 
	private AcademicOfferFactoryService academicOfferFactoryService;

	@PostConstruct
	private void initialize() {
		academicOfferFactoryService.initialize();
	}
	
}
