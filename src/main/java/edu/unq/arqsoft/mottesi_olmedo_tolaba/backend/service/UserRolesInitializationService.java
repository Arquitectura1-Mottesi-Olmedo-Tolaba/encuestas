package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesInitializationService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired 
	private AcademicOfferFactoryService academicOfferFactoryService;
	
	@Autowired 
	private StatisticsFactoryService statisticsFactoryService;

	@Autowired
	private DirectorService directorService;
	
	@PostConstruct
	private void initialize() {
		academicOfferFactoryService.initialize();
	}
	
}
