package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.DirectorDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Director;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.UserCredential;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.DirectorRepository;


@Transactional
@Service
public class DirectorService extends GenericService<Director> {

	@Autowired
	private DirectorRepository repository;
	
	public DirectorService() {}
	
	public DirectorService(DirectorRepository repo) {
		this.setRepository(repo);
	}

	public DirectorRepository getRepository() {
		return repository;
	}

	public void setRepository(DirectorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Director update(Director model) {
		return super.update(model);
	}
	
	@Transactional
	public Director save(Director model) {
		return super.save(model);
	}

	public Director create(UserCredential adminUser, Degree degree) {
		Director director = new Director(degree,adminUser);
		return this.save(director);
	}

	public DirectorDTO getDirectorDTO(Long id) {
		Director director = this.find(id);
		return new DirectorDTO(Arrays.asList(director.getDegree().toDTO()),director.getUser());
	}



}