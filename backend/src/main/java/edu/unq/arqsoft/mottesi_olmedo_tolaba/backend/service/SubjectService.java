package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.SubjectRepository;


@Transactional
@Service
public class SubjectService extends GenericService<Subject> {

	@Autowired
	private SubjectRepository repository;
	
	public SubjectService() {}
	
	public SubjectService(SubjectRepository repo) {
		this.setRepository(repo);
	}

	public SubjectRepository getRepository() {
		return repository;
	}

	public void setRepository(SubjectRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Subject update(Subject model) {
		return super.update(model);
	}
	
	@Transactional
	public Subject save(Subject model) {
		return super.save(model);
	}
	

}
