package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SurveyDTO implements Serializable{

	private static final long serialVersionUID = -4655259408872462825L;
	public List<SurveyMatchDTO> surveyMatches = new LinkedList<SurveyMatchDTO>();
	
	public SurveyDTO(){	
	}
	
	public SurveyDTO(List<SurveyMatchDTO> surveyMatches){
		this.surveyMatches = surveyMatches;
	}
	
	public void addSurveyMatchDTO(SurveyMatchDTO surveyMatch){
		this.surveyMatches.add(surveyMatch);
	}
	
	
}
