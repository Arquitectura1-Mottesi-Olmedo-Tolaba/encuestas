package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyDTO;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto.SurveyMatchDTO;

@Entity
@Table(name = "surveys")
public class Survey extends PersistenceEntity {

	private static final long serialVersionUID = 9159344780394535641L;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<SurveyMatch> surveyMatches = new LinkedList<SurveyMatch>();	

	public Survey() {
    }
	
	public SurveyDTO toSurveyDTO() {
		SurveyDTO dto = new SurveyDTO();
		List<SurveyMatchDTO> surveyMatchesDTO = new LinkedList<SurveyMatchDTO>();
		for (SurveyMatch surveyMatch : surveyMatches){
			surveyMatchesDTO.add(surveyMatch.toSurveyMatchDTO());
		}
		dto.surveyMatches = surveyMatchesDTO;
		return dto;
    } 
	

	public List<SurveyMatch> getSurveyMatches() {
		return surveyMatches;
	}

	public void setSurveyMatches(List<SurveyMatch> surveyMatches) {
		this.surveyMatches = surveyMatches;
	}
	
	public void addSurveyMatch(SurveyMatch surveyMatch){
		this.surveyMatches.add(surveyMatch);
	}
}
