package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;

public class StatisticDTO implements Serializable{
	
	private static final long serialVersionUID = 6398518148191713691L;
	public Long id;
    public SubjectDTO subject;
    public List<OptionCounter> optionsCounter;

    public StatisticDTO(){}
    

	public StatisticDTO(Long id, SubjectDTO subject, List<OptionCounter> optionsCounter) {
		this.id = id;
		this.subject = subject;
		this.optionsCounter = optionsCounter;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
