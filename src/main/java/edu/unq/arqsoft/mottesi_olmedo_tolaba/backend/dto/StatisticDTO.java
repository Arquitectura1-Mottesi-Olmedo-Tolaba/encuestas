package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;

public class StatisticDTO implements Serializable{
	
	private static final long serialVersionUID = 6398518148191713691L;
    private Subject subject;
	private List<OptionCounterDTO> info;

	public StatisticDTO(Subject subject, List<OptionCounterDTO> info) {
		this.subject = subject;
		this.info = info;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<OptionCounterDTO> getInfo() {
		return info;
	}

	public void setInfo(List<OptionCounterDTO> info) {
		this.info = info;
	}
}
