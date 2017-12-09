package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;

public class SurveyMatchDTO implements Serializable{

	private static final long serialVersionUID = -4655259408872462825L;
	public SubjectDTO subject;
	public OptionDTO option;
	
	public SurveyMatchDTO(){	
	}
	
	public SurveyMatchDTO(SubjectDTO subject, OptionDTO option){
		this.subject = subject;
		this.option = option;
	}
	
}
