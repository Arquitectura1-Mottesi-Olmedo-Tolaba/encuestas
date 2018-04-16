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

	public List<String> findCodes(Long idDegree) {
		String hql1 = "SELECT academicOffer.id FROM Degree as degree"
				+ " inner join degree.academicOffers as academicOffer"
				+ " where degree.id = :idDegree";
		Query query1 = this.getSessionFactory().getCurrentSession().createQuery(hql1)
        		.setParameter("idDegree", idDegree);
		List<Long> academicOffers = query1.list();
		String hql2 = "SELECT survey.code FROM Survey as survey"
				+ " inner join survey.academicOffer as academicOffer"
				+ " where academicOffer.active = :active"
				+ " and academicOffer.id in (:academicOffers)";
        Query query2 = this.getSessionFactory().getCurrentSession().createQuery(hql2)
        		.setParameter("active", true)
        		.setParameterList("academicOffers", academicOffers);
        return query2.list();
	}

	public List<Survey> findByUser(Long userId) {
		String query = "SELECT survey FROM Survey as survey " +
				"WHERE survey.student = ? "; 
		return (List<Survey>) this.getHibernateTemplate().find(query, userId );

	}
}
