package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;

@Repository
@SuppressWarnings("unchecked")
public class OptionCounterRepository extends HibernateGenericDAO<OptionCounter> implements GenericRepository<OptionCounter> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<OptionCounter> options;
	
	public OptionCounterRepository() {
		this.setOptions(new LinkedList<OptionCounter>());
	}
	
	@Override
	public Class<OptionCounter> getDomainClass() {
		return OptionCounter.class;
	}

	public List<OptionCounter> getOptions() {
		return options;
	}

	public void setOptions(List<OptionCounter> options) {
		this.options = options;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
