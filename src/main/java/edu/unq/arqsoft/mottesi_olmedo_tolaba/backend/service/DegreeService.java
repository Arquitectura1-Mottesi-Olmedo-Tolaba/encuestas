package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Degree;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.DegreeRepository;


@Transactional
@Service
public class DegreeService extends GenericService<Degree> {

	@Autowired
	private DegreeRepository repository;
	
	public DegreeService() {}
	
	public DegreeService(DegreeRepository repo) {
		this.setRepository(repo);
	}

	public DegreeRepository getRepository() {
		return repository;
	}

	public void setRepository(DegreeRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Degree update(Degree model) {
		return super.update(model);
	}
	
	@Transactional
	public Degree save(Degree model) {
		return super.save(model);
	}

	public String getDegreeName(Long idDegree) {
		return this.find(idDegree).getName();
	}


}
