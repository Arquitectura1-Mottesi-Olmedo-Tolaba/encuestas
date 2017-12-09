package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.SurveyMatchRepository;


@Transactional
@Service
public class SurveyMatchService extends GenericService<SurveyMatch> {

	@Autowired
	private SurveyMatchRepository repository;
	
	public SurveyMatchService() {}
	
	public SurveyMatchService(SurveyMatchRepository repo) {
		this.setRepository(repo);
	}

	public SurveyMatchRepository getRepository() {
		return repository;
	}

	public void setRepository(SurveyMatchRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public SurveyMatch update(SurveyMatch model) {
		return super.update(model);
	}
	
	@Transactional
	public SurveyMatch save(SurveyMatch model) {
		return super.save(model);
	}
	
	
}
