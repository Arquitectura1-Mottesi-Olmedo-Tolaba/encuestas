package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.TimeResponse;


@Repository
public class TimeResponseRepository extends HibernateGenericDAO<TimeResponse> implements GenericRepository<TimeResponse>{

	private static final long serialVersionUID = 1L;

	private List<TimeResponse> timeResponses;

	public List<TimeResponse> getTimeResponses() {
		return timeResponses;
	}

	public void setTimeResponses(List<TimeResponse> timeResponses) {
		this.timeResponses = timeResponses;
	}

	public TimeResponseRepository(){
		this.timeResponses = new ArrayList<TimeResponse>();
	}
	
	public void save(TimeResponse timeResponse) {
		this.timeResponses.add(timeResponse);		
	}

	@Override
	public Class<TimeResponse> getDomainClass() {
		return TimeResponse.class;
	}	
}
