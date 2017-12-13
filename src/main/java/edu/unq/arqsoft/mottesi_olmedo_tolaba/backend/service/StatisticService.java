package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.StatisticDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.AcademicOffer;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.StatisticRepository;


@Transactional
@Service
public class StatisticService extends GenericService<Statistic> {

	@Autowired
	private StatisticRepository repository;
	
	@Autowired
	private OptionCounterService optionCounterService;
	
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
	public Statistic newStatistic(Subject subject, List<OptionCounter> optionsCounter, AcademicOffer academicOffer) {
		Statistic stat = new Statistic(subject, optionsCounter,academicOffer);
		return this.save(stat);
	}

	public List<StatisticDTO> findAllDTO() {
		List<StatisticDTO> res = new ArrayList<StatisticDTO>();
		for (Statistic st : this.findAll()){
			res.add(makeStatisticDTO(st));
		}
		return res;
	}

	private StatisticDTO makeStatisticDTO(Statistic st) {
		return new StatisticDTO(st.getId(),st.getAcademicOffer().getId(),
				st.getSubject().toSubjectDTO(),st.getOptionsCounter());
	}

	public StatisticDTO findDTO(Long id) {
		return makeStatisticDTO(this.find(id));
	}

	public List<StatisticDTO> findDTOByAcademicOffer(Long id) {
		List<StatisticDTO> res = new ArrayList<StatisticDTO>();
		for (Statistic st : this.findByAcademicOffer(id)){
			res.add(makeStatisticDTO(st));
		}
		return res;
	}

	public List<Statistic> findByAcademicOffer(Long id) {
		return this.getRepository().findByAcademicOffer(id);
	}

	public void updateFromSurvey(SurveyMatchDTO smDTO, AcademicOffer academicOffer) {
		/*
		
		Por cada subject de surveyMatch
		Statistic stad = Le hago un find by academicOffer and subject
		
		Filtro la optionCounter con misma descripcion que el option(de sm o smDTO)
		
		Y a esa le hago amount ++  y capacity --
		
		*/
		Statistic stat = this.findBySubjectAndAcademicOffer(smDTO.subject.getId(), academicOffer.getId());
		for (OptionCounter op : stat.getOptionsCounter()){
			if (op.getDescription().equals(smDTO.option.getDescription())){
				Integer newAmount = op.getAmount() + 1;
				Integer newCapacity = op.getCapacity() - 1;
				op.setAmount(newAmount);
				op.setCapacity(newCapacity);
				optionCounterService.update(op);
			}
		}
		
	}

	private Statistic findBySubjectAndAcademicOffer(Long subjectId, Long academicOfferId) {
		// TODO Auto-generated method stub
		return this.repository.findBySubjectAndAcademicOffer(subjectId,academicOfferId);
	}


}
