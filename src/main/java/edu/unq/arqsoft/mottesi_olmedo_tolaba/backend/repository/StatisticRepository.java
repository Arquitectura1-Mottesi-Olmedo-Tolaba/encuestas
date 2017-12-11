package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
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

	
}
