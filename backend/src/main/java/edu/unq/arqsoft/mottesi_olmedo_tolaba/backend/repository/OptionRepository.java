package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Offer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;

@Repository
@SuppressWarnings("unchecked")
public class OptionRepository extends HibernateGenericDAO<Option> implements GenericRepository<Option> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Option> options;
	
	public OptionRepository() {
		this.setOptions(new LinkedList<Option>());
	}
	
	@Override
	public Class<Option> getDomainClass() {
		return Option.class;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
