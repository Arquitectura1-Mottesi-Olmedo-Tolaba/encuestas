package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public Director findDirector(UserCredential credential){
		return this.getRepository().findDirector(credential);
	}

}