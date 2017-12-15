package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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

	public Survey getByCode(String code) {
		String query = "SELECT survey FROM " + this.persistentClass.getName() + " survey "
				+ "WHERE survey.code = ? ";
		List<Survey> surveys = (List<Survey>) this.getHibernateTemplate().find(query, code);
		return surveys.isEmpty() ? null : surveys.get(0);
	}

	public Integer surveysCompletedOf(Long academicOfferId) {
		String hql = "SELECT count(survey) FROM Survey as survey" +
                " inner join survey.academicOffer as academicOffer" +
                " where academicOffer.id = :academicOfferId and survey.wasAnswered = :wasAnswered";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                .setParameter("academicOfferId", academicOfferId)
                .setParameter("wasAnswered", true);
        return  ((Long) query.uniqueResult()).intValue();
	}


    public Boolean verifyCode(String code) {
        String hql = "SELECT survey FROM Survey as survey" +
                " where survey.code = :code";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                .setParameter("code", code);
        return  query.uniqueResult() != null;
    }
}
