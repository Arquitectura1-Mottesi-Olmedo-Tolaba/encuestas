package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.SurveyRepository;


@Transactional
@Service
public class SurveyService extends GenericService<Survey> {

	@Autowired
	private SurveyRepository repository;
	
	public SurveyService() {}
	
	public SurveyService(SurveyRepository repo) {
		this.setRepository(repo);
	}

	public SurveyRepository getRepository() {
		return repository;
	}

	public void setRepository(SurveyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Survey update(Survey model) {
		return super.update(model);
	}
	
	@Transactional
	public Survey save(Survey model) {
		return super.save(model);
	}
	
	public Survey newSurvey(List<SurveyMatch> surveyMatches) {
		Survey elem = new Survey();
		elem.setSurveyMatches(surveyMatches);
		return this.save(elem);
	}
	
}
