package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.OptionDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Course;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.OptionCounterRepository;


@Transactional
@Service
public class OptionCounterService extends GenericService<OptionCounter> {

	@Autowired
	private OptionCounterRepository repository;
	
	public OptionCounterService() {}
	
	public OptionCounterService(OptionCounterRepository repo) {
		this.setRepository(repo);
	}
	
	public OptionCounterRepository getRepository() {
		return repository;
	}

	public void setRepository(OptionCounterRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public OptionCounter update(OptionCounter model) {
		return super.update(model);
	}
	
	@Transactional
	public OptionCounter save(OptionCounter model) {
		return super.save(model);
	}
	

}
