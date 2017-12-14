package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Role;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;

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
		Role role = new Role("DIRECTOR");
		role = roleService.save(role);
		UserCredential directorUser =
				new UserCredential("director", "director", "director@gmail.com" ,Arrays.asList(role));
		userService.save(directorUser);
		academicOfferFactoryService.initialize();

	}
	
}
