package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.TimeLineDTO;
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
	
	public TimeLineDTO timeLineToDTO(Timeline timeline) {
		TimeLineDTO timeLineDTO = new TimeLineDTO();
		timeLineDTO.setDay(timeline.getDayTime());
		timeLineDTO.setEnd(timeline.getEndTime());
		timeLineDTO.setStart(timeline.getStartTime());
		timeLineDTO.setId(timeline.getId());
		return timeLineDTO;
	}
	
	public List<TimeLineDTO> timeLinesToDTO(List<Timeline> timeLines){
		List<TimeLineDTO> timeLinesDTO = new ArrayList<TimeLineDTO>();
		for(Timeline each : timeLines) {
			timeLinesDTO.add(timeLineToDTO(each));
		}
		return timeLinesDTO;
	}
}
