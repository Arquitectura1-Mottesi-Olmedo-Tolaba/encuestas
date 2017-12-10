package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;

@Repository
@SuppressWarnings("unchecked")
public class SurveyMatchRepository extends HibernateGenericDAO<SurveyMatch> implements GenericRepository<SurveyMatch> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<SurveyMatch> surveyMatches;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SurveyMatchRepository() {
		this.setSurveyMatches(new LinkedList<SurveyMatch>());
	}

	@Override
	public Class<SurveyMatch> getDomainClass() {
		return SurveyMatch.class;
	}

	public List<SurveyMatch> getSurveyMatches() {
		return surveyMatches;
	}

	public void setSurveyMatches(List<SurveyMatch> surveyMatches) {
		this.surveyMatches = surveyMatches;
	}


}
