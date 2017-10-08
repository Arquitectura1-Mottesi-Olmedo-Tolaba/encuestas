package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.TimelineRepository;


@Transactional
@Service
public class TimelineService extends GenericService<Timeline> {

	@Autowired
	private TimelineRepository repository;
	
	public TimelineService() {}
	
	public TimelineService(TimelineRepository repo) {
		this.setRepository(repo);
	}

	public TimelineRepository getRepository() {
		return repository;
	}

	public void setRepository(TimelineRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Timeline update(Timeline model) {
		return super.update(model);
	}
	
	@Transactional
	public Timeline save(Timeline model) {
		return super.save(model);
	}
	

}
