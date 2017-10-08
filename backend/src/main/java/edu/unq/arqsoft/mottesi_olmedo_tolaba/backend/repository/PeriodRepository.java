package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;

@Repository
@SuppressWarnings("unchecked")
public class PeriodRepository extends HibernateGenericDAO<Period> implements GenericRepository<Period> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Period> periods;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PeriodRepository() {
		this.setPeriods(new LinkedList<Period>());
	}

	@Override
	public Class<Period> getDomainClass() {
		return Period.class;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}


}
