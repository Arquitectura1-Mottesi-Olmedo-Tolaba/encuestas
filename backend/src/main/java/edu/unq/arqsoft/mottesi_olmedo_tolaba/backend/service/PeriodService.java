package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.PeriodRepository;


@Transactional
@Service
public class PeriodService extends GenericService<Period> {

	@Autowired
	private PeriodRepository repository;
	
	public PeriodService() {}
	
	public PeriodService(PeriodRepository repo) {
		this.setRepository(repo);
	}

	public PeriodRepository getRepository() {
		return repository;
	}

	public void setRepository(PeriodRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Period update(Period model) {
		return super.update(model);
	}
	
	@Transactional
	public Period save(Period model) {
		return super.save(model);
	}
	

}
