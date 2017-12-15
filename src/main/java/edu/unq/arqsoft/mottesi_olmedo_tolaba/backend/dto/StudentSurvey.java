package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.util.List;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.SurveyMatch;

public class StudentSurvey {

	private String code;
	private List<SurveyMatch> surveyMatches;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<SurveyMatch> getSurveyMatches() {
		return surveyMatches;
	}

	public void setSurveyMatches(List<SurveyMatch> surveyMatches) {
		this.surveyMatches = surveyMatches;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentSurvey() {
		super();
	}

	public StudentSurvey(String code, List<SurveyMatch> surveyMatches, String message) {
		super();
		this.code = code;
		this.surveyMatches = surveyMatches;
		this.message = message;
	}

}
