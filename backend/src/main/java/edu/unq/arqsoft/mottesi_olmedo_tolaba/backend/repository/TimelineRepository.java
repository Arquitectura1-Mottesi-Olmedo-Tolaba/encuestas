package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Timeline;

@Repository
@SuppressWarnings("unchecked")
public class TimelineRepository extends HibernateGenericDAO<Timeline> implements GenericRepository<Timeline> {

	private static final long serialVersionUID = -4425722631916607857L;

	private List<Timeline> timelines;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TimelineRepository() {
		this.setTimelines(new LinkedList<Timeline>());
	}

	@Override
	public Class<Timeline> getDomainClass() {
		return Timeline.class;
	}

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}


}
