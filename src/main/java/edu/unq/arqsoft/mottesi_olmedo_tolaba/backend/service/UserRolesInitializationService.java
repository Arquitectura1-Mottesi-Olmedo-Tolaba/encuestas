package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Role;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;

@Service
public class UserRolesInitializationService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired 
	private AcademicOfferFactoryService academicOfferFactoryService;
	
	@PostConstruct
	private void initialize() {
		List<Role> roles = new LinkedList<Role>();
		roles.add(roleService.save(new Role("ADMIN")));
		roles.add(roleService.save(new Role("DIRECTOR")));
		roles.add(roleService.save(new Role("STUDENT")));
		
		UserCredential adminUser = new UserCredential("admin", "admin");
		adminUser.addRoles(roles);
		userService.save(adminUser);
		academicOfferFactoryService.initialize();
	}
	
}
