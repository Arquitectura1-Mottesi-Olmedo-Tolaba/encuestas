package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;

@Repository
@SuppressWarnings("unchecked")
public class StatisticRepository extends HibernateGenericDAO<Statistic> implements GenericRepository<Statistic> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Statistic> statistics;
	
	public StatisticRepository() {
		this.setStatistics(new LinkedList<Statistic>());
	}
	
	@Override
	public Class<Statistic> getDomainClass() {
		return Statistic.class;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Statistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}

	public List<Statistic> findByAcademicOffer(Long id) {
		String query = "SELECT statistic FROM " + persistentClass.getName() + " statistic "
				+ "WHERE statistic.academicOffer.id = ? ";
		List<Statistic> statistics = (List<Statistic>) this.getHibernateTemplate().find(query, id);
		if (statistics.isEmpty()) {
			return null;
		} else {
			return statistics;
		}
	}

	public Statistic findBySubjectAndAcademicOffer(Long subjectId, Long academicOfferId) {
		String query = "SELECT statistic FROM " + persistentClass.getName() + " statistic "
				+ "WHERE statistic.academicOffer.id = ? "
				+ "AND statistic.subject.id = ?";
		List<Statistic> statistics = (List<Statistic>) this.getHibernateTemplate().find(query, subjectId, academicOfferId );
		if (statistics.isEmpty()) {
			return null;
		} else {
			return statistics.get(0);
		}
	}

	
}
