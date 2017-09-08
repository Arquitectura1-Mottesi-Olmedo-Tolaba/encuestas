package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Role;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.GenericRepository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.RoleRepository;


@Transactional
@Service
public class RoleService extends GenericService<Role> {

	@Autowired
	private RoleRepository repository;

	public Role findByName(String role) {
		return repository.findByName(role);
	}
	
	@Transactional
	private void validateRoleNameExistence(String roleName, Role roleToCompare) {
		Role role = repository.findByName(roleName);
		if (role != null) {
			Boolean sameId = roleToCompare.getId() != null && roleToCompare.getId().equals(role.getId());
			if (role.getId() == null || !sameId) {
				throw new RuntimeException("A role with the name " + roleName + " has already been created");
			}
		}
	}
	
	@Transactional
	public Role update(Role newRole) {
		validateRoleNameExistence(newRole.getName(), newRole);
		return super.update(newRole);
	}
	
	public Role save(Role newRole) {
		validateRoleNameExistence(newRole.getName(), newRole);
		return super.save(newRole);
	}

	@Override
	public GenericRepository<Role> getRepository() {
		return this.repository;
	}

}
