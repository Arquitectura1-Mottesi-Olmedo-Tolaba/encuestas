package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Survey;

@Repository
@SuppressWarnings("unchecked")
public class SurveyRepository extends HibernateGenericDAO<Survey> implements GenericRepository<Survey> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Survey> surveys;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SurveyRepository() {
		this.setSurveys(new LinkedList<Survey>());
	}

	@Override
	public Class<Survey> getDomainClass() {
		return Survey.class;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}


}
