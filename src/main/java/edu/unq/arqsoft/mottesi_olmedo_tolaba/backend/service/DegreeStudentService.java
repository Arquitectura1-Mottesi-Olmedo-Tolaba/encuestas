package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.DegreeStudent;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.DegreeStudentRepository;


@Transactional
@Service
public class DegreeStudentService extends GenericService<DegreeStudent> {

	@Autowired
	private DegreeStudentRepository repository;
	
	public DegreeStudentService() {}
	
	public DegreeStudentService(DegreeStudentRepository repo) {
		this.setRepository(repo);
	}

	public DegreeStudentRepository getRepository() {
		return repository;
	}

	public void setRepository(DegreeStudentRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public DegreeStudent update(DegreeStudent model) {
		return super.update(model);
	}
	
	@Transactional
	public DegreeStudent save(DegreeStudent model) {
		return super.save(model);
	}

	public Integer studentsForDegree(Long idDegree) {
		return this.repository.studentsForDegree(idDegree);
	}

}
