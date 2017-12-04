package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.OptionDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.PeriodDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.TimeLineDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Option;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Period;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.OptionRepository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository.PeriodRepository;


@Transactional
@Service
public class OptionService extends GenericService<Option> {

	@Autowired
	private OptionRepository repository;
	
	public OptionService() {}
	
	public OptionService(OptionRepository repo) {
		this.setRepository(repo);
	}
	
	public OptionRepository getRepository() {
		return repository;
	}

	public void setRepository(OptionRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Option update(Option model) {
		return super.update(model);
	}
	
	@Transactional
	public Option save(Option model) {
		return super.save(model);
	}
	
	@Transactional
	public Option newOption(String description) {
		Option newOption = new Option();
		newOption.setDescription(description);
		return this.save(newOption);
	}
	
	public OptionDTO optionToDTO(Option option) {
		OptionDTO optionDTO = new OptionDTO();
		optionDTO.setId(option.getDescription());
		optionDTO.setDescription(option.getDescription());
		
		return optionDTO;
	}
	
	public List<OptionDTO> optionsToDTO(List<Option> options){
		List<OptionDTO> optionsDTO = new ArrayList<OptionDTO>();
		for(Option each : options) {
			optionsDTO.add(optionToDTO(each));
		}
		return optionsDTO;
	}
	

}
