package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "timelines")
public class Timeline extends PersistenceEntity {

	private static final long serialVersionUID = 5143900452863118731L;
	private String dayTime;
	private String startTime;
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStart(String start) {
		this.startTime = start;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String end) {
		this.endTime = end;
	}

	public Timeline() {
	}

	public Timeline(String dayTime, String startTime, String endTime) {
		this.dayTime = dayTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDayTime() {
		return dayTime;
	}

	public void setDayTime(String day) {
		this.dayTime = day;
	}

}
