package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.OptionCounterRepository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.StatisticRepository;


@Transactional
@Service
public class StatisticService extends GenericService<Statistic> {

	@Autowired
	private StatisticRepository repository;
	
	public StatisticService() {}
	
	public StatisticService(StatisticRepository repo) {
		this.setRepository(repo);
	}
	
	public StatisticRepository getRepository() {
		return repository;
	}

	public void setRepository(StatisticRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Statistic update(Statistic model) {
		return super.update(model);
	}
	
	@Transactional
	public Statistic save(Statistic model) {
		return super.save(model);
	}
	
	@Transactional
	public Statistic newStatistic(Subject subject, List<OptionCounter> optionsCounter) {
		Statistic stat = new Statistic(subject, optionsCounter);
		return this.save(stat);
	}


}
